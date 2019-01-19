package com.reynolds.lawrence.codingPractice.hackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import org.junit.Test;

public class Warmup_Test {
	@Test
    public void withInput() {
    	int n = 0;
    	int posCount = 0;
    	int negCount = 0;
    	
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/warmup/inputFile.txt");
		final File file = new File(fileURL.getFile());
    	
        try (
        		FileReader r = new FileReader(file);
        		BufferedReader br = new BufferedReader(r)
        	){
        	n = Integer.parseInt(br.readLine());
        	String[] values = br.readLine().split(" ");
        	for(int i = 0; i < n; i++){
        		int value = Integer.parseInt(values[i]);
        		if (value > 0)
        			posCount++;
        		else if (value < 0)
        			negCount++;
        	}
        	System.out.println((double)posCount/n);
        	System.out.println((double)negCount/n);
        	System.out.println((double)(n - posCount - negCount)/n);
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
//    @Test
    public void stairCase(){
    	try {
			int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			char[] steps = new char[n];
			Arrays.fill(steps, ' ');
			for (int step = 0; step < n; step++){
				steps[n - step - 1] = '#';
				System.out.println(steps);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void timeConversion(){
		final URL fileURL = this.getClass().getClassLoader().getResource("hackerRank/warmup/timeConversionInput.txt");
		final File file = new File(fileURL.getFile());
		
    	try (
    			FileReader fr = new FileReader(file);
    			BufferedReader br = new BufferedReader(fr);
    			){
    		String inputTime = null;
    		while((inputTime = br.readLine()) != null){
	    		//hh:mm:ssAM or hh:mm:ssPM
	    		
    			String hourString = inputTime.substring(0, 2);
    			
    			int hourInt = Integer.parseInt(hourString);
	    		boolean isPm = inputTime.charAt(8) == 'P';
	    		
	    		if(isPm && (hourInt != 12)){
	    			hourString = Integer.toString(hourInt += 12);
	    		}
	    		else if (!isPm && hourInt == 12)
	    		{
	    			hourString = "00";
	    		}
	    		
	    		System.out.println(hourString + inputTime.substring(2, 8));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
