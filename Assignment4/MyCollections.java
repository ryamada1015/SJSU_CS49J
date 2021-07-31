package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class MyCollections {

	public static void main(String[] args) {
//		Stack<File> files = new Stack<File>();
//		files.push(new File("file1.txt"));
//		files.push(new File("file2.txt"));
//		files.push(new File("file3.txt"));
//		printFiles(files);
//		
//		LinkedList<String> employees = new LinkedList<String>();
//		employees.add("John");
//		employees.add("Alice");
//		employees.add("Bethany");
//		employees.add("Keith");
//		employees.add("Nasu");
//		employees.add("Naomi");
//		employees.add("Apryl");
//		employees.add("Lucy");
//		employees.add("Jonny");
//		employees.add("Chris");
//		employees.add("Mercedez");
//		downsize(employees, 3);
		
//		isBalanced("([])");
//		isBalanced("([)]");
		
		
	}

	public static void printFiles(Stack<File> files) {
		try {
			if(files.empty()) {
				System.out.println("There is no files to open.");
				return;
			}
			
			while(!files.empty()) {
				Scanner reader = new Scanner(files.peek());
				
				while(reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
				System.out.println("***");
				
				files.pop();
				reader.close();
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void downsize(LinkedList<String> employees, int interval) {
		try {
			ListIterator<String> it = employees.listIterator();
			for(int i = 1; i <= employees.size(); i++) {
				it.next();
				if(i % interval == 0) {
					it.remove();
				}
			}
			for(String str:employees) {
				System.out.println(str);
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public static void isBalanced(String str) {
		Stack<Character> s = new Stack<>();
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(' || chars[i] == '[') {
				s.push(Character.valueOf(chars[i]));
			}
			else if(chars[i] == ')' && s.peek() == '(') {
				s.pop();
			}
			else if(chars[i] == ']' && s.peek() == '[') {
				s.pop();
			}
		}
		if(s.isEmpty())
			System.out.println("Parantheses balanced.");
		else
			System.out.println("Parantheses not balanced.");
		
	}
}
