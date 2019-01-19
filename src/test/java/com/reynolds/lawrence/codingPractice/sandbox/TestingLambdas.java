package com.reynolds.lawrence.codingPractice.sandbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <ul>
 * 		<li><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html">Lambda Expressions</a></li>
 * 		<li><a href="https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html">Method References</a></li>
 * 		<li><a href="https://docs.oracle.com/javase/tutorial/collections/streams/index.html">Lesson: Aggregate Operations</a></li>
 * 		<li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html">Stream Interface</a></li>
 * 		<li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">Package java.util.function</a></li>
 * </ul>
 * 
 * @author Lawrence Reynolds
 *
 */
public class TestingLambdas {
	
	@Test
	public void basicFilterTest() throws InvalidMidiDataException, IOException {

		List<String> stringList = new ArrayList<String>();
		
		stringList.add("test1");
		stringList.add("test2");
		stringList.add("test3");
		stringList.add("test4");
		stringList.add("test5");
		stringList.add("test6");
		stringList.add("test6");
		stringList.add("test6");
		
		long countTest3 = stringList.stream().filter(string -> "test3".equals(string)).count();
		assertEquals(1, countTest3);
		
		long countTest6 = stringList.stream().filter(string -> "test6".equals(string)).count();
		assertEquals(3, countTest6);
		
	}
}
