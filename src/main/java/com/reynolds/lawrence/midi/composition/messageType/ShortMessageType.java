package com.reynolds.lawrence.midi.composition.messageType;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.ShortMessage;

public enum ShortMessageType {

	ACTIVE_SENSING(ShortMessage.ACTIVE_SENSING), // Status
	CHANNEL_PRESSURE(ShortMessage.CHANNEL_PRESSURE), // Command
	CONTINUE(ShortMessage.CONTINUE), // Status
	CONTROL_CHANGE(ShortMessage.CONTROL_CHANGE), // Command
	END_OF_EXCLUSIVE(ShortMessage.END_OF_EXCLUSIVE), // Status - may need to treat similar to sysex
	MIDI_TIME_CODE(ShortMessage.MIDI_TIME_CODE), // Status
	NOTE_OFF(ShortMessage.NOTE_OFF), // Command
	NOTE_ON(ShortMessage.NOTE_ON), // Command
	PITCH_BEND(ShortMessage.PITCH_BEND), // Command
	POLY_PRESSURE(ShortMessage.POLY_PRESSURE), // Command
	PROGRAM_CHANGE(ShortMessage.PROGRAM_CHANGE), // Command
	SONG_POSITION_POINTER(ShortMessage.SONG_POSITION_POINTER), // Status
	SONG_SELECT(ShortMessage.SONG_SELECT), // Status
	START(ShortMessage.START), // Status
	STOP(ShortMessage.STOP), // Status
	SYSTEM_RESET(ShortMessage.SYSTEM_RESET), // Status - same as meta message. Need to make sure this isn't checked.
	TIMING_CLOCK(ShortMessage.TIMING_CLOCK), // Status
	TUNE_REQUEST(ShortMessage.TUNE_REQUEST); // Status

	private int typeDataByte;

	private static Map<Integer, ShortMessageType> typeDataByteToShortMessageEventTypeMap = new HashMap<>();

	static {
		for (final ShortMessageType shortMessageType : ShortMessageType.values()) {
			typeDataByteToShortMessageEventTypeMap.put(shortMessageType.typeDataByte, shortMessageType);
		}
	}

	private ShortMessageType(final int typeDataByte) {
		this.typeDataByte = typeDataByte;
	}

	public static ShortMessageType getMetaEventTypeFromTypeDataByte(final int typeDataByte) {
		return typeDataByteToShortMessageEventTypeMap.get(typeDataByte);
	}
}
