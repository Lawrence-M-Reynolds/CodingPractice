package com.reynolds.lawrence.midi.composition.messageType;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.ShortMessage;

public enum ShortMessageCommandType {

	CHANNEL_PRESSURE(ShortMessage.CHANNEL_PRESSURE),
	CONTROL_CHANGE(ShortMessage.CONTROL_CHANGE),
	NOTE_OFF(ShortMessage.NOTE_OFF),
	NOTE_ON(ShortMessage.NOTE_ON),
	PITCH_BEND(ShortMessage.PITCH_BEND),
	POLY_PRESSURE(ShortMessage.POLY_PRESSURE),
	PROGRAM_CHANGE(ShortMessage.PROGRAM_CHANGE);

	private int typeDataByte;

	private static Map<Integer, ShortMessageCommandType> typeDataByteToShortMessageCommandTypeMap = new HashMap<>();

	static {
		for (final ShortMessageCommandType shortMessageCommandType : ShortMessageCommandType.values()) {
			typeDataByteToShortMessageCommandTypeMap.put(shortMessageCommandType.typeDataByte, shortMessageCommandType);
		}
	}

	private ShortMessageCommandType(final int typeDataByte) {
		this.typeDataByte = typeDataByte;
	}

	public static ShortMessageCommandType getShortMessageCommandTypeFromTypeDataByte(final int typeDataByte) {
		return typeDataByteToShortMessageCommandTypeMap.get(typeDataByte);
	}
}
