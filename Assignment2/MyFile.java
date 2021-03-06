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
		
//		while(in.hasNextLine()) {
//			String str = in.nextLine();
//			Scanner reader = new Scanner(str);
//			reader.useDelimiter(",");
//			while(reader.hasNext()) {
//				String token = reader.next();
//				int i;
//				if(isInt(token) && Integer.parseInt(token) >= 2) {
//					int num = Integer.parseInt(token);
//					for(i = 2; i <= Math.sqrt(num); i++) {
//						if(num%i == 0)
//							break;
//					}
//					if(i > Math.sqrt(num)) {
//						System.out.println(num);
//						outputFile.println(num);
//					}
//				}
//			}
//			reader.close();
//		}
			
		reader.useDelimiter("[,\n]");
		
		while(reader.hasNext()) {
			String input = reader.next();
			int num = 0;
			if(isInt(input))
					num = Integer.parseInt(input);
			else if(num <= 1) continue;
			int i;
			for(i = 2; i < num; i++) {
				if(num%i == 0)
					break;
			}
			if(i == num) {
				outputFile.println(num);
			}
		}
				
		outputFile.close();
		reader.close();
		
		
	}
	
	private static boolean isInt(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) 
				return false;
		}
		return true;
	}

}
