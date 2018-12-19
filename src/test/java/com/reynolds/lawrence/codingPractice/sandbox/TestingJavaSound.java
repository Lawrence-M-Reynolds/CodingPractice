package com.reynolds.lawrence.codingPractice.sandbox;

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
		
		System.out.println("PPQ: " + sequence.PPQ);
		System.out.println("DivisionType: " + sequence.getDivisionType());
		
		/* This is ticks per beat. */
		System.out.println("Resolution: " + sequence.getResolution());
		
		Track[] tracks = sequence.getTracks();
		for(Track track : tracks) {
			for(int eventIndex = 0; eventIndex < track.size(); eventIndex++) {
				MidiEvent midiEvent = track.get(eventIndex);
				System.out.println("Tick: " + midiEvent.getTick());
				System.out.println("Length: " + midiEvent.getMessage().getLength());
				System.out.println("Status: " + midiEvent.getMessage().getStatus());
				
				byte[] messageBytes = midiEvent.getMessage().getMessage();
				for(byte messageByte : messageBytes) {
					System.out.println("\tmessageByte: " + Integer.toBinaryString(messageByte));
				}
				
				midiEvent.setTick(midiEvent.getTick() + sequence.getResolution() / 2);
			}
		}
		
		Path path = Paths.get("./output", "testMidiFileOut.mid");
		
		MidiSystem.write(sequence, fileTypes[0], path.toFile());
	}
}
