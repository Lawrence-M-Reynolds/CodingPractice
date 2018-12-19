package com.reynolds.lawrence.codingPractice.sandbox;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import org.junit.Test;
/**
 * Sandbox tests.
 * 
 * @author lawrencereynolds
 *
 */
public class TestingBinary {

//	@Test
	public void loopAllValuesInAByte() throws InvalidMidiDataException, IOException {

		byte i = -128;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));
		} while(++i < 128 && i > -128);
	}
	
//	@Test
	public void invertByte() throws InvalidMidiDataException, IOException {

		final int MIN = Byte.MIN_VALUE;
		final int MAX = Byte.MAX_VALUE;
		
		int i = MIN;
		do {
			System.out.println(i + ":\t\t" + Integer.toString(i, 2));
			
			int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toString(j, 2) + "\n");
		} while(++i <= MAX && i > MIN);
	}
	
//	@Test
	public void invertShort() throws InvalidMidiDataException, IOException {

		final int MIN = Short.MIN_VALUE;
		final int MAX = Short.MAX_VALUE;
		
		int i = MIN;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));
			
			int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toBinaryString(j) + "\n");
			
			if(i == 260) {
				break;
			}
			
			i += 1;
		} while(i <= MAX && i > MIN);
	}
	
//	@Test
	public void invertInt() throws InvalidMidiDataException, IOException {

		int i = Integer.MIN_VALUE;
		do {
			System.out.println(i + ":\t\t" + Integer.toBinaryString(i));
			
			int j = ~i;
			System.out.println(j + ":\t\t" + Integer.toBinaryString(j) + "\n");
			i += 10;
		} while(i < Integer.MAX_VALUE && i > Integer.MIN_VALUE);
	}

//	@Test
	public void byteTooBig() throws InvalidMidiDataException, IOException {

		byte i = (byte)0x7F;
		System.out.println(i + ":\t\t" + Integer.toBinaryString(i).replace(' ', '0'));
	}

//	@Test
	public void test2() throws InvalidMidiDataException, IOException {

		byte b1 = (byte) 129;
		String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
		System.out.println(s1); // 10000001

		byte b2 = (byte) 2;
		String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
		System.out.println(s2); // 00000010
	}
	
//	@Test
	public void test3() throws InvalidMidiDataException, IOException {

		short b1 = Byte.MAX_VALUE;
		System.out.println(Integer.toBinaryString(b1));
		
		short b2 = Byte.MAX_VALUE + 1;
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
		} while(i < MAX && i > MIN);
		
	}
}
