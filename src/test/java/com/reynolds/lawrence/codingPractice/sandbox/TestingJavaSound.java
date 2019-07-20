package com.reynolds.lawrence.codingPractice.sandbox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import com.reynolds.lawrence.midi.binary.BinaryUtil;
import org.junit.Test;

import com.reynolds.lawrence.midi.composition.Composition;
import com.reynolds.lawrence.midi.composition.MidiTranslationManager;

/**
 * Sandbox tests for simple investigation into how the Java Sound API works.
 *
 * @see
 *      <ul>
 *      	<li><a href="https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/MidiEvent.html">API</a></li>
 *      	<li><a href="https://www.recordingblogs.com/wiki/header-chunk-of-a-midi-file">Midi Header</a></li>
 *      	<li><a href="http://www.indiana.edu/~emusic/etext/MIDI/chapter3_MIDI4.shtml">Midi notes</a></li>
 *      	<li><a href="https://www.recordingblogs.com/wiki/midi-meta-messages">MIDI meta messages</a></li>
 *      </ul>
 *
 * @author lawrencereynolds
 *
 */
public class TestingJavaSound {

	private static final String OUTPUT_DIRECTORY_PATH = "./output";
	private static final String TEST_INPUT_MIDI_FILE_PATH = "midi/testForMidiKeyChange.mid";

	@Test
	public void callTests() throws InvalidMidiDataException, IOException {
		/* Easier to enable/disable relavent tests this way. */
		//		this.loadFromFile();

		this.loadFromFile();
	}

	/**
	 * Investigating how to get the data from a midi file using Java Sound.
	 *
	 * @throws InvalidMidiDataException
	 * @throws IOException
	 */
	private void loadFromFile() throws InvalidMidiDataException, IOException {
		final URL fileURL = this.getClass().getClassLoader().getResource(TEST_INPUT_MIDI_FILE_PATH);
		System.out.println("fileURL: " + fileURL);
		System.out.println("fileURL.getFile(): " + fileURL.getFile());

		final File testMidiFile = new File(fileURL.getFile());
		final Sequence sequence = MidiSystem.getSequence(testMidiFile);

		System.out.println("#Generated Midi");

		System.out.println("##Meta Data");
		/*
		 * We only expect a file type of "1" where the first track holds some meta event
		 * data.
		 */
		final int[] fileTypes = MidiSystem.getMidiFileTypes(sequence);
		final StringBuilder typesString = new StringBuilder("\nfile types:");
		for (final int type : fileTypes) {
			typesString.append(" ");
			typesString.append(type);
		}
		System.out.println(typesString.toString());

		/*
		 * We expect to only work in "pulses (ticks) per quarter note". Not frames per
		 * second.
		 */
		System.out.println("\nDivisionType is PPQ: " + Boolean.toString(sequence.getDivisionType() == Sequence.PPQ));

		/* This is ticks per beat. */
		System.out.println("\nResolution: " + sequence.getResolution());

		final Track[] tracks = sequence.getTracks();
		System.out.println("\nNumber of Tracks: " + tracks.length);

		System.out.println("##Tracks");

		byte trackNum = 0;
		for (final Track track : tracks) {
			if (trackNum == 0) {
				/* This is the meta track. Holds info such as tempo changes etc. */

				System.out.println("\n### Meta CompositionTrack");

				for (int eventIndex = 0; eventIndex < track.size(); eventIndex++) {
					System.out.println("\n####NEW EVENT");

					final MidiEvent midiEvent = track.get(eventIndex);

					/* Delta time - time in ticks from previous event. */
					System.out.println("\nTick: " + midiEvent.getTick());

					final MetaMessage metaMessage = (MetaMessage) midiEvent.getMessage();

					System.out.println("\nLength: " + metaMessage.getLength());
					//					System.out.println("Status: " + metaMessage.getStatus()); // Meta events always have a status of 255

					final byte[] messageBytes = metaMessage.getMessage();
					for (final byte messageByte : messageBytes) {
						int byteAsUnsignedInt = BinaryUtil.convertSignedIntToByteAsUnsignedInt(messageByte);

						String binaryRepresentation = BinaryUtil.getByteUnSignedIntAsBinaryString(byteAsUnsignedInt);
						System.out.println("\nMessage Byte: " + binaryRepresentation + " / " + Integer.toHexString(byteAsUnsignedInt) + " / " + byteAsUnsignedInt);
					}

					/*
					sequence.getResolution() is basically the denominator of the time signature. So
					this is moving by a half beat forwards.
					 */
					midiEvent.setTick(midiEvent.getTick() + sequence.getResolution() / 2);
				}
			} else {
				/* Regular tracks with the note on/off information as well as meta events. */

				System.out.println("\n### CompositionTrack Number: " + trackNum);

				for (int eventIndex = 0; eventIndex < track.size(); eventIndex++) {
					System.out.println("\n####NEW EVENT");
					final MidiEvent midiEvent = track.get(eventIndex);

					System.out.println("\nTick: " + midiEvent.getTick());
					System.out.println("\nLength: " + midiEvent.getMessage().getLength());
					System.out.println("\nStatus: " + midiEvent.getMessage().getStatus());

					final byte[] messageBytes = midiEvent.getMessage().getMessage();
					for (final byte messageByte : messageBytes) {
						int byteAsUnsignedInt = BinaryUtil.convertSignedIntToByteAsUnsignedInt(messageByte);

						String binaryRepresentation = BinaryUtil.getByteUnSignedIntAsBinaryString(byteAsUnsignedInt);
						System.out.println("\nMessage Byte: " + binaryRepresentation + " / " + Integer.toHexString(byteAsUnsignedInt) + " / " + byteAsUnsignedInt);
					}

					/*
					sequence.getResolution() is basically the denominator of the time signature. So
					this is moving by a half beat forwards.
					 */
					midiEvent.setTick(midiEvent.getTick() + sequence.getResolution() / 2);
				}
			}

			trackNum++;
		}

		final Path outputDirectoryPath = Paths.get(OUTPUT_DIRECTORY_PATH);
		Files.createDirectories(outputDirectoryPath);

		final Path outputFilePath = Paths.get(OUTPUT_DIRECTORY_PATH, "testMidiFileOut.mid");
		MidiSystem.write(sequence, fileTypes[0], outputFilePath.toFile());
	}

	/**
	 * Testing the creation of the data model from a loaded midi file.
	 *
	 * @throws InvalidMidiDataException
	 * @throws IOException
	 */
	private void createDataModelFromMidiFile() throws InvalidMidiDataException, IOException {
		final URL fileURL = this.getClass().getClassLoader().getResource(TEST_INPUT_MIDI_FILE_PATH);

		final File testMidiFile = new File(fileURL.getFile());

		final Composition composition = MidiTranslationManager.createCompositionFromMidiFile(testMidiFile);

		final Path outputDirectoryPath = Paths.get(OUTPUT_DIRECTORY_PATH);
		Files.createDirectories(outputDirectoryPath);

		final Path outputFilePath = Paths.get(OUTPUT_DIRECTORY_PATH, "testMidiFileOutFromModel.mid");

		MidiTranslationManager.saveCompositionToMidiFile(composition, outputFilePath);

	}
}
