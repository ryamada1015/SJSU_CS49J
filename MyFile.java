package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {

	public static void main(String[] args) {
		try {
			writePrimes("file1.txt", "file2.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	public static void writePrimes(String file1, String file2) throws FileNotFoundException {
		File inputFile = new File(file1);
		PrintWriter outputFile = new PrintWriter(file2);
		
		Scanner reader = new Scanner(inputFile);
			
		reader.useDelimiter(",");
		
		while(reader.hasNext()) {
			String input = reader.next();
			if(!isInt(input)) continue;
			int num = Integer.parseInt(input);
				
			for(int i = 2; i < 100; i++) {
				if(num == 1 || (num != i && num%i == 0)) {
					continue;
				}else {
					System.out.println(num);
					outputFile.println(num);
					break;
				}
			}
				
		}
		
		//inputFile.close();
		outputFile.close();
		
		
	}
	
	private static boolean isInt(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}

}
