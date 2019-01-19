package com.reynolds.lawrence.codingPractice.hackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;

import org.junit.Test;

public class Implementation_Test {

	/**
	 * 12.20 - 12.34
	 */
	@Test
	public void anrgyProfessor(){
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/Implementation/angryProfessor.txt");
		final File file = new File(fileURL.getFile());
		
		try(
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
			)
			{
				int t = Integer.parseInt(br.readLine());
				
				for(int i = 0; i < t; i++){
					String[] firstLine = br.readLine().split(" ");
					int numStudents = Integer.parseInt(firstLine[0]);
					int threshold = Integer.parseInt(firstLine[1]);
					
					String[] values = br.readLine().split(" ");
					
					for(int j = 0; j < numStudents; j++){
						if(threshold < 0){
							break;
						}else if(Integer.parseInt(values[j]) <= 0){
							threshold--;
						}
					}
					
					if(threshold > 0){
						System.out.println("YES");
					}else{
						System.out.println("NO");
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 */
	@Test
	public void sherlockAndTheBeast(){
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/Implementation/sherlockAndTheBeast.txt");
		final File file = new File(fileURL.getFile());
		
		try(
				FileReader input = new FileReader(file);
//				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input);
			)
			{
				int numTestCases = Integer.parseInt(br.readLine());
				
				for(int testCase = 0; testCase < numTestCases; testCase++){
					int n = Integer.parseInt(br.readLine());
					
					int numFives = n;
					int numThrees = 0;
					boolean found = false;
					
					while(!found && numFives >= 0){
						found = (numFives % 3 == 0)
								&& (numThrees % 5 == 0);
						
						if(!found){
							numFives--;
							numThrees++;
						}
					}
					
					if(found){
						char[] number = new char[n];
						for(int i = 0; i < n; i++){
							number[i] = i < numFives ? '5' : '3';
						}
						System.out.println(number);
					} else {
						System.out.println("-1");
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void utopianTree(){
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/Implementation/utopianTree.txt");
		final File file = new File(fileURL.getFile());
		
		try(
				FileReader input = new FileReader(file);
//				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input);
			)
			{
				int numTestCases = Integer.parseInt(br.readLine());
				for (int testCase = 0; testCase < numTestCases; testCase++){
					int size = 1;
					int numCycles = Integer.parseInt(br.readLine());
					
					for(int cycle = 1; cycle <= numCycles; cycle++)
					{
						if(cycle % 2 == 0)
						{
							// Add 1
							size += 1;
						}
						else
						{
							// Double
							size = size * 2;
						}
					}
					System.out.println(size);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void findDigits(){
		long start = System.currentTimeMillis();
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/Implementation/findDigits.txt");
		final File file = new File(fileURL.getFile());
		
		try(
				FileReader input = new FileReader(file);
//				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input);
			)
			{
				int numTestCases = Integer.parseInt(br.readLine());
				for(int testCase = 0; testCase < numTestCases; testCase++)
				{
					int value = Integer.parseInt(br.readLine());
					int result = 0;
					
					char[] digits = Integer.toString(value).toCharArray();
					for(char charDigit : digits)
					{
						int digit = Character.getNumericValue(charDigit);
						if(digit != 0 && value % digit == 0)
						{
							result++;
						}
					}
					System.out.println(result);
				}

				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		long time = (System.currentTimeMillis() - start);
		System.out.println("Time: " + time);
		//27, 30, 29, 28, 25, 27, 23, 32
	}
	
	/**
	 * My bad solution.
	 * Better one offered on the site is to find the roots of the end points only. Then just find how many
	 * integers between them.
	 */
	@Test
	public void sherlockAndSquares(){
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/Implementation/sherlockAndSquares_5.txt");
		final File file = new File(fileURL.getFile());
		
		try(
				FileReader input = new FileReader(file);
//				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input);
			)
			{
				LinkedHashMap<Integer, Integer> squares = new LinkedHashMap<Integer, Integer>(46340);
				int squareCount = 0;
				for(int i = 1; i < Integer.MAX_VALUE; i++)
				{
					int square = i*i;
					if (square < Integer.MAX_VALUE && square > 0)
					{
						squares.put(square, ++squareCount);
					}
					else
					{
						break;
					}
				}
				
				int numTestCases = Integer.parseInt(br.readLine());
				for(int testCase = 0; testCase < numTestCases; testCase++)
				{
					String[] stringValues = br.readLine().split(" ");
					int firstValue = Integer.parseInt(stringValues[0]);
					int secondValue = Integer.parseInt(stringValues[1]);
					
					int lowerCount = 0;
					int upperCount = 0;
					for(int i = firstValue; i <= secondValue; i++ )
					{
						if(lowerCount == 0 && squares.containsKey(i)){
							lowerCount = squares.get(i);
						}
						if(upperCount == 0 && squares.containsKey(secondValue + firstValue - i)){
							upperCount = squares.get(secondValue + firstValue - i);
						}
						if(lowerCount != 0 && upperCount != 0){
							break;
						}
					}
					int result = (lowerCount == 0 ? 0 : (upperCount - lowerCount + 1));
					System.out.println(result);
				}
			} catch (FileNotFoundException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
