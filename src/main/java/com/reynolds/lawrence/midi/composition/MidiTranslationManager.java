package com.reynolds.lawrence.midi.composition;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reynolds.lawrence.midi.binary.BinaryUtil;
import com.reynolds.lawrence.midi.composition.messageType.MessageStatusType;
import com.reynolds.lawrence.midi.composition.messageType.MetaEventType;
import com.reynolds.lawrence.midi.composition.messageType.ShortMessageCommandType;

public class MidiTranslationManager {
	final static Logger LOG = LoggerFactory.getLogger(MidiTranslationManager.class);

	public static Composition createCompositionFromMidiFile(final File testMidiFile)
			throws InvalidMidiDataException, IOException {

		final Sequence sequence = MidiSystem.getSequence(testMidiFile);

		final String compositionName = testMidiFile.getName();
		final CompositionMetaData compositionMetaData = createCompositionMetaData(sequence);

		final List<Track> tracks = getCompositionTracks(sequence);
		final Track metaTrack = tracks.remove(0);

		final Composition composition = new Composition(compositionName, compositionMetaData, metaTrack, tracks);

		return composition;
	}

	private static List<Track> getCompositionTracks(final Sequence sequence) {

		final List<Track> compositionTracks = new ArrayList<Track>();

		final javax.sound.midi.Track[] tracks = sequence.getTracks();
		LOG.debug("Number of Tracks: {}", tracks.length);

		for (final javax.sound.midi.Track midiTrack : tracks) {
			LOG.debug("*************** Track Number: {}", compositionTracks.size() + 1);

			final Track track = new Track();

			/* Midi stores the time of events as deltas. The number of ticks from the previous event. We
			 * can't use this in the data model as we need to separate the note events from other events,
			 * such as the meta events. So instead, here we're calculating the absolute time of each event
			 * by just adding the delta time from the previous event.  */
			int absoluteTime = 0;
			for (int eventIndex = 0; eventIndex < midiTrack.size(); eventIndex++) {
				final MidiEvent midiEvent = midiTrack.get(eventIndex);

				final long eventDeltaTime = midiEvent.getTick();
				absoluteTime += eventDeltaTime;
				LOG.debug("absoluteTime: {}", absoluteTime);

				final MidiMessage midiMessage = midiEvent.getMessage();

				/* I don't think these are necessary. */
				//				final int length = midiMessage.getLength();
				//				final byte[] messageData = midiMessage.getMessage();

				final int status = convertSignedIntToUnsignedInt(midiMessage.getStatus());
				final MessageStatusType messageStatusType = MessageStatusType
						.getMessageStatusTypeFromTypeDataByte(status);

				LOG.debug("status: {}, messageStatusType: {}", status, messageStatusType);

				switch (messageStatusType) {
				case META:
					/*
					 * Create a new MetaEvent object and add it to the meta event list of the track.
					 */
					/* This is a meta message. Note: in a real-time midi signal it could be a "system reset message"
					 * short ShortMessage. But with midie files it will be a MetaMessage. */
					final MetaMessage metaMessage = (MetaMessage) midiMessage;
					final int type = convertSignedIntToUnsignedInt(metaMessage.getType());
					final MetaEventType metaEventType = MetaEventType.getMetaEventTypeFromTypeDataByte(type);
					LOG.debug("metaEventType: {}", metaEventType);
					break;

				case MIDI_TIME_CODE:
				case SONG_POSITION_POINTER:
				case SONG_SELECT:
				case TUNE_REQUEST:
				case END_OF_EXCLUSIVE: // may add to sysEx
					/*
					 * Create a new MetaEvent object and add it to the meta event list of the track.
					 */
					/* This is a meta message. Note: in a real-time midi signal it could be a "system reset message"
					 * short ShortMessage. But with midie files it will be a MetaMessage. */
					final ShortMessage shortMessage = (ShortMessage) midiMessage;
					final int channel = convertSignedIntToUnsignedInt(shortMessage.getChannel());
					final int command = convertSignedIntToUnsignedInt(shortMessage.getCommand());
					LOG.debug("channel: {}", channel);
					LOG.debug("command: {}", command);

					final ShortMessageCommandType shortMessageCommandType = ShortMessageCommandType
							.getShortMessageCommandTypeFromTypeDataByte(command);

					LOG.debug("shortMessageCommandType: {}", shortMessageCommandType);
					break;
				case SPECIAL_SYSTEM_EXCLUSIVE:
				case SYSTEM_EXCLUSIVE:
					/*
					 * I don't think either of these should occur. If they do then they can both be
					 * treated the same and added as a SystemExclusive Event object to the relevant
					 * list of the track.
					 */
					final SysexMessage sysexMessage = (SysexMessage) midiMessage;
					break;
				}
			}

			compositionTracks.add(track);
		}
		return compositionTracks;
	}

	public static void saveCompositionToMidiFile(final Composition composition, final Path outputFilePath) {

	}

	private static CompositionMetaData createCompositionMetaData(final Sequence sequence) {
		/*
		 * We only expect a file type of "1" where the first track holds some meta event
		 * data.
		 */
		final int[] supportedMidiFileTypes = MidiSystem.getMidiFileTypes(sequence);
		final float divisionType = sequence.getDivisionType();
		final int resolution = sequence.getResolution();

		return new CompositionMetaData(supportedMidiFileTypes, divisionType, resolution);
	}

	public static int convertSignedIntToUnsignedInt(final int signedInt) {
		//		return signedInt;
		return signedInt & BinaryUtil.FIRST_EIGHT_BITS_MASK;
	}

}
