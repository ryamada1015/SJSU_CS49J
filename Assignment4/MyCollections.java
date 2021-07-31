package edu.sjsu.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MyCollections {

	public static void main(String[] args) {
//		Queue<File> files = new LinkedList<File>();
//		files.add(new File("file1.txt"));
//		files.add(new File("file2.txt"));
//		files.add(new File("file3.txt"));
//		printFiles(files);
//		
		LinkedList<String> employees = new LinkedList<String>();
		employees.add("John");
		employees.add("Alice");
		employees.add("Bethany");
		employees.add("Keith");
		employees.add("Nasu");
		employees.add("Naomi");
//		employees.add("Apryl");
//		employees.add("Lucy");
//		employees.add("Jonny");
//		employees.add("Chris");
//		employees.add("Mercedez");
//		downsize(employees, 3);
		
//		isBalanced("([])");
//		isBalanced("([)]");
		
		
	}

	public static void printFiles(Queue<File> files) {
		try {
			if(files.isEmpty()) {
				System.out.println("There is no files to open.");
				return;
			}
			
			while(!files.isEmpty()) {
				Scanner reader = new Scanner(files.peek());
				
				while(reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
				System.out.println("***");
				
				files.poll();
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
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isBalanced(String str) {
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
			else return false;
		}
		if(s.isEmpty())
			return true;
		else
			return false;
		
	}
}
