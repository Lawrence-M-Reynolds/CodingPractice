package com.reynolds.lawrence.midi.composition.messageType;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @see
 *      <ul>
 *      	<li><a href="https://www.recordingblogs.com/wiki/midi-meta-messages">MIDI meta messages</a></li>
 *      </ul>
 *
 * @author lawrencereynolds
 *
 */
public enum MetaEventType {

	/** The number of a sequence. */
	SEQUENCE_NUMBER(0x00),

	/** Some text. */
	TEXT(0x01),

	/** A copyright notice. */
	COPYRIGHT(0x02),

	/** A track name. */
	TRACK_NAME(0x03),

	/** The name of an instrument in the current track. */
	INSTRUMENT_NAME(0x04),

	/** Lyrics, usually a syllable per quarter note. */
	LYRICS(0x05),

	/** The text of a marker. */
	MARKER(0x06),

	/** The text of a cue, usually to prompt for some action from the user. */
	CUE_POINT(0x07),

	/** A channel number (final following meta events will apply to this channel). */
	CHANNEL_PREFIX(0x10),

	/** At the end of track. */
	END_OF_TRACK(0x2F),

	/** The number of microseconds per beat. */
	SET_TEMPO(0x51),

	/** SMPTE time to denote playback offset from the beginning. */
	SMPTE_OFFSET(0x54),

	/** Time signature, metronome clicks, and size of a beat in 32nd notes. */
	TIME_SIGNATURE(0x58),

	/** A key signature. */
	KEY_SIGNATURE(0x59),

	/** Something specific to the MIDI device manufacturer. */
	SEQUENCER_SPECIFIC(0x74);

	private int typeDataByte;

	private static Map<Integer, MetaEventType> typeDataByteToMetaEventTypeMap = new HashMap<>();

	static {
		for (final MetaEventType metaEventType : MetaEventType.values()) {
			typeDataByteToMetaEventTypeMap.put(metaEventType.typeDataByte, metaEventType);
		}
	}

	private MetaEventType(final int typeDataByte) {
		this.typeDataByte = typeDataByte;
	}

	public static MetaEventType getMetaEventTypeFromTypeDataByte(final int typeDataByte) {
		return typeDataByteToMetaEventTypeMap.get(typeDataByte);
	}
}
