package com.reynolds.lawrence.codingPractice.midi;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

import org.junit.Test;
/**
 * Sandbox tests for simple investigation into how the Java Sound API works. 
 * 
 * @author lawrencereynolds
 *
 */
public class TestingJavaSound {

	@Test
	public void callTests() throws InvalidMidiDataException, IOException {
		loadFromFile();
	}
	
	private void loadFromFile() throws InvalidMidiDataException, IOException{
		URL fileURL = this.getClass().getClassLoader().getResource("midi/testMidiFile.mid");
		System.out.println("fileURL: " + fileURL);
		System.out.println("fileURL.getFile(): " + fileURL.getFile());
		
		File testMidiFile = new File(fileURL.getFile());
		Sequence sequence = MidiSystem.getSequence(testMidiFile);
		
		int[] fileTypes = MidiSystem.getMidiFileTypes(sequence);
		StringBuilder typesString = new StringBuilder("file types:");
		for(int type : fileTypes) {
			typesString.append(" ");
			typesString.append(type);
		}
		System.out.println(typesString.toString());
		
		
	}
}
