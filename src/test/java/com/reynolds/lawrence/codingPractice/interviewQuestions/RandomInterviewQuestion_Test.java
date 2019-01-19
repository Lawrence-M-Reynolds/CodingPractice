package com.reynolds.lawrence.codingPractice.interviewQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class RandomInterviewQuestion_Test {

	@Test
	public void stringPermutations(){
		String largeString = "dcbahfdjvncdsbiortabcdvndknvkdnvcdbakvdfkvdfabcd";
		String smallString = "abcd";
		/*
		 * Find how manypermuations of the small string in the big string.
		 * 3
		 */
		
		// Add the chars from the small string to a set.
		// Iterate through large string check contains of the set on it.
		// When it finds one add the length of the string number of chars to another set.
		// Perform equals with the first set.
		// If it's equal then add that string to a third Set
		// Repeat the othe step again.
		
		char[] smallStringArray = smallString.toCharArray();
		char[] largeStringArray = largeString.toCharArray();
		Set<List<Character>> resultSet = new HashSet<List<Character>>();
		
		Set<Character> smallStringChars = new HashSet<Character>();
		for(char c : smallStringArray)
			smallStringChars.add(c);
		
		for(int i=0; i < largeStringArray.length - (smallStringArray.length - 1); i++){
			Character c = largeStringArray[i];
			if(smallStringChars.contains(c)){
				Set<Character> charCheckSet = new HashSet<Character>();
				Character[] subStringCharArray = new Character[smallStringArray.length];
				for(int f = i; ((f-i) < smallStringArray.length) && (f < largeString.length()); f++){
					subStringCharArray[f - i] = largeStringArray[f];
				}
				for(int j = 0; j < subStringCharArray.length; j++){
					charCheckSet.add(subStringCharArray[j]);
				}
				System.out.println(Arrays.asList(subStringCharArray));
				if (charCheckSet.equals(smallStringChars)){
					System.out.println("valid");
					resultSet.add(Arrays.asList(subStringCharArray));
				}
			}
		}
		System.out.println(resultSet);
		System.out.println(resultSet.size());
	}
}
