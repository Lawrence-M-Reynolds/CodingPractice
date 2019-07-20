package com.reynolds.lawrence.codingPractice.sandbox;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sandbox tests.
 *
 * @author lawrencereynolds
 *
 */
public class TestingBinary {
	final Logger logger = LoggerFactory.getLogger(TestingBinary.class);

	//	@Test
	public void loopAllValuesInAByte() throws InvalidMidiDataException, IOException {

		byte i = -128;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));
		} while (++i < 128 && i > -128);
	}

	//	@Test
	public void invertByte() throws InvalidMidiDataException, IOException {

		final int MIN = Byte.MIN_VALUE;
		final int MAX = Byte.MAX_VALUE;

		int i = MIN;
		do {
			System.out.println(i + ":\t\t" + Integer.toString(i, 2));

			final int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toString(j, 2) + "\n");
		} while (++i <= MAX && i > MIN);
	}

	//	@Test
	public void invertShort() throws InvalidMidiDataException, IOException {

		final int MIN = Short.MIN_VALUE;
		final int MAX = Short.MAX_VALUE;

		int i = MIN;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));

			final int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toBinaryString(j) + "\n");

			if (i == 260) {
				break;
			}

			i += 1;
		} while (i <= MAX && i > MIN);
	}

	//	@Test
	public void invertInt() throws InvalidMidiDataException, IOException {

		int i = Integer.MIN_VALUE;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));

			final int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toBinaryString(j) + "\n");
			i += 10;
		} while (i < Integer.MAX_VALUE && i > Integer.MIN_VALUE);
	}

	//	@Test
	public void byteTooBig() throws InvalidMidiDataException, IOException {

		final byte i = (byte) 0x7F;
		System.out.println(i + ":\t\t" + Integer.toBinaryString(i).replace(' ', '0'));
	}

	//	@Test
	public void test2() throws InvalidMidiDataException, IOException {

		final byte b1 = (byte) 129;
		final String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
		System.out.println(s1); // 10000001

		final byte b2 = (byte) 2;
		final String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
		System.out.println(s2); // 00000010
	}

	//	@Test
	public void test3() throws InvalidMidiDataException, IOException {

		final short b1 = Byte.MAX_VALUE;
		System.out.println(Integer.toBinaryString(b1));

		final short b2 = Byte.MAX_VALUE + 1;
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(b2);

		System.out.println(Integer.toBinaryString(-b2));
		System.out.println(-b2);

	}

	@Test
	public void testingComplementGivesNegative() throws InvalidMidiDataException, IOException {

		final int MIN = Short.MIN_VALUE;
		final int MAX = Short.MAX_VALUE;

		int i = MIN;
		do {
			assertEquals(-i - 1, ~i);
			i += 1;
		} while (i < MAX && i > MIN);

	}

	@Test
	public void printByteBitsAsString() throws InvalidMidiDataException, IOException {

		final byte b1 = (byte) 127;
		final byte b2 = (byte) 2;
		final byte b3 = (byte) -52;

		/* A mask for the first 8 bits of the byte. */
		short BYTE_MASK = 0xFF;

		/* Apply the mask to the bytes which casts them up to ints. Leading 1's will be removed
		* beyond the 8 bits so these are no longer signed ints (which uses 2's compliment). */
		int b1_lsb_int = BYTE_MASK & b1;
		int b2_lsb_int = BYTE_MASK & b2;
		int b3_lsb_int = BYTE_MASK & b3;

		/*
		Getting the string representation of the new 32 bit integers. Note that this function doesn't return
		leading zeros. So after applying the mask this String will only be 8 characters long or shorter.
		 */
		String b1_IntBinaryAsString = Integer.toBinaryString(b1_lsb_int);
		String b2_IntBinaryAsString = Integer.toBinaryString(b2_lsb_int);
		String b3_IntBinaryAsString = Integer.toBinaryString(b3_lsb_int);

		/*
		 Using the formatter here to extract only the 8 least significant bits. It also pads from the left of the
		 string with spaces if there are not enough characters to make the string up to a length of 8.

		See https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax

		"The width is the minimum number of characters to be written to the output. If the length of the converted
		value is less than the width then the output will be padded by '  ' ('\u0020') until the total number of
		characters equals the width. The padding is on the left by default. If the '-' flag is given, then the
		padding will be on the right. If the width is not specified then there is no minimum."

		Width is 8 so the string is padded on the left by default with spaces.
		The "-" flag would apply the padding from the right. E.g. "%-8s".

		 */
		final String b1_SpaceBufferedByteBinaryAsString = String.format("%8s", b1_IntBinaryAsString);
		final String b2_SpaceBufferedByteBinaryAsString = String.format("%8s", b2_IntBinaryAsString);
		final String b3_SpaceBufferedByteBinaryAsString = String.format("%8s", b3_IntBinaryAsString);

		/*
		Simply replacing the padded spaces with 0's. This will only be necessary if the string returned having
		applied the mask was shorter than 8 characters.
		 */
		String b1_ByteBinaryAsString = b1_SpaceBufferedByteBinaryAsString.replace(' ', '0');
		String b2_ByteBinaryAsString = b2_SpaceBufferedByteBinaryAsString.replace(' ', '0');
		String b3_ByteBinaryAsString = b3_SpaceBufferedByteBinaryAsString.replace(' ', '0');

		System.out.println(b1 + ": " + b1_ByteBinaryAsString); // 10000001
		System.out.println(b2 + ": " + b2_ByteBinaryAsString); // 10000001
		System.out.println(b3 + ": " + b3_ByteBinaryAsString); // 10000001

	}
}
