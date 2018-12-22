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
}
