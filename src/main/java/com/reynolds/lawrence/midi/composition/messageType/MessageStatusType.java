package com.reynolds.lawrence.midi.composition.messageType;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;

import com.reynolds.lawrence.midi.binary.ByteConversionUtil;

/**
*
* @see
*      <ul>
*      	<li><a href="https://www.midi.org/specifications/item/table-1-summary-of-midi-message">MIDI Status types</a></li>
*      </ul>
*
* @author lawrencereynolds
*
*/
public enum MessageStatusType {
	/** Meta message status type. */
	META(MetaMessage.META),

	/** Meta message status types. */
	SPECIAL_SYSTEM_EXCLUSIVE(SysexMessage.SPECIAL_SYSTEM_EXCLUSIVE),
	SYSTEM_EXCLUSIVE(SysexMessage.SYSTEM_EXCLUSIVE),

	/** Short message Status types. */
	//	ACTIVE_SENSING(ShortMessage.ACTIVE_SENSING), /* We won't be using this for midi files.. */
	//	CONTINUE(ShortMessage.CONTINUE), /* We won't be using this for midi files.. */
	END_OF_EXCLUSIVE(ShortMessage.END_OF_EXCLUSIVE),
	MIDI_TIME_CODE(ShortMessage.MIDI_TIME_CODE),
	SONG_POSITION_POINTER(ShortMessage.SONG_POSITION_POINTER),
	SONG_SELECT(ShortMessage.SONG_SELECT),
	//	START(ShortMessage.START), /* We won't be using this for midi files.. */
	//	STOP(ShortMessage.STOP), /* We won't be using this for midi files.. */
	//		SYSTEM_RESET(ShortMessage.SYSTEM_RESET), /* We won't be using this for midi files. This is the same as Meta. */
	//	TIMING_CLOCK(ShortMessage.TIMING_CLOCK), /* We won't be using this for midi files.. */
	TUNE_REQUEST(ShortMessage.TUNE_REQUEST),

	/** Short message command status types. */
	CHANNEL_PRESSURE(ShortMessage.CHANNEL_PRESSURE),
	CONTROL_CHANGE(ShortMessage.CONTROL_CHANGE),
	NOTE_OFF(ShortMessage.NOTE_OFF),
	NOTE_ON(ShortMessage.NOTE_ON),
	PITCH_BEND(ShortMessage.PITCH_BEND),
	POLY_PRESSURE(ShortMessage.POLY_PRESSURE),
	PROGRAM_CHANGE(ShortMessage.PROGRAM_CHANGE);

	private int typeDataByte;

	private static Map<Integer, MessageStatusType> typeDataByteToMessageStatusTypeMap = new HashMap<>();

	static {
		for (final MessageStatusType messageStatusType : MessageStatusType.values()) {
			typeDataByteToMessageStatusTypeMap.put(messageStatusType.typeDataByte, messageStatusType);
		}
	}

	private MessageStatusType(final int typeDataByte) {
		this.typeDataByte = typeDataByte;
	}

	public static MessageStatusType getMessageStatusTypeFromTypeDataByte(final int typeDataByte) {
		MessageStatusType messageStatusType;
		if (typeDataByte < ByteConversionUtil.FIRST_FOUR_BITS_MASK) {
			/*
			 * Status messages less than 240 use only the first four bits to indicate the status. The
			 * rest are used to define the channel. See:
			 * https://www.midi.org/specifications/item/table-1-summary-of-midi-message
			 */
			messageStatusType = typeDataByteToMessageStatusTypeMap.get(typeDataByte & ByteConversionUtil.FIRST_FOUR_BITS_MASK);
		} else {
			messageStatusType = typeDataByteToMessageStatusTypeMap.get(typeDataByte);
		}
		return messageStatusType;
	}

}
