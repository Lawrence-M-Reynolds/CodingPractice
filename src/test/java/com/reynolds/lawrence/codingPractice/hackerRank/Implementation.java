package com.reynolds.lawrence.codingPractice.hackerRank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

public class Implementation {

	/**
	 * 12.20 - 12.34
	 */
//	@Test
	public void anrgyProfessor(){
		try(
				FileReader fr = new FileReader("resources/hackerRank/Implementation/angryProfessor.txt");
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
		try(
				FileReader input = new FileReader("resources/hackerRank/Implementation/sherlockAndTheBeast.txt");
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
}
