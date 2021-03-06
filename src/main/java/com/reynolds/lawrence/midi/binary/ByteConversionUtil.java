package com.reynolds.lawrence.midi.binary;

public class ByteConversionUtil {

	private ByteConversionUtil(){
		throw new AssertionError("Util class not to be instantiated.");
	}

	/** 240, 0xF0 or 0b11110000. Can be used to extract the four most significant bits of a byte. */
	public static final int FIRST_FOUR_BITS_MASK = 0xF0;

	/** 255, 0xFF, or 0b11111111. Used to convert from a signed int to an unsigned int. */
	public static final int FIRST_EIGHT_BITS_MASK = 0xFF;

	public static int convertSignedIntToByteAsUnsignedInt(int byteAsSignedInt) {
		return FIRST_EIGHT_BITS_MASK & byteAsSignedInt;
	}

	/**
	 * Returns a string representation of a byte (as an unsigned int) in binary
	 * form. For debugging purposes.
	 * @param byteAsUnsignedInt byte as an unsigned int,
	 * @return the string representation of the byte in binary form.
	 */
	public static String getByteUnSignedIntAsBinaryString(int byteAsUnsignedInt) {
		String binaryString = Integer.toBinaryString(byteAsUnsignedInt);
		return String.format("%8s", binaryString).replace(' ', '0');
	}
}
