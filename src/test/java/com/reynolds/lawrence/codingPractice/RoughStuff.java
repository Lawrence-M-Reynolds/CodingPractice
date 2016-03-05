package com.reynolds.lawrence.codingPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RoughStuff {
	
//	@Test
	public void stack(){
		Stack<Integer> s = new Stack<Integer>();
		
		Integer[] ints = {1,4, 4, 2, 5, 5, 5};
		
		
		for(int i : ints){
			s.push(i);
		}
		System.out.println("stack: " + s);
		
		for(int i : ints){
			System.out.println("peeking: " + s.peek());
		}
		System.out.println("stack: " + s);
		
		for(int i : ints){
			System.out.println("popping: " + s.pop());
		}
		System.out.println("stack: " + s);
	}
	
//	@Test
	public void removeDuplicates(){
		List<Integer> withDups = new LinkedList<>();
		
		withDups.add(1);
		withDups.add(1);
		withDups.add(2);
		withDups.add(4);
		withDups.add(3);
		
		System.out.println("withDups: " + withDups);
		
		withDups = new ArrayList<>(new HashSet<>(withDups));
		
		System.out.println("withoutDups: " + withDups);
	}

	@Test
	public void x(){
		List<Integer> withDups = new LinkedList<>();
		
		withDups.add(1);
		withDups.add(1);
		withDups.add(2);
		withDups.add(4);
		withDups.add(3);
		
		System.out.println("withDups: " + withDups);
		
		withDups = new ArrayList<>(new LinkedHashSet<>(withDups));
		
		System.out.println("withoutDups: " + withDups);
	}
}
