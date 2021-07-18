package edu.sjsu.assignment2;

public class MyRecursion {

	public static void main(String[] args) {
		System.out.println(indexOf("hi 49J", "49J"));
		
	}
	
	public static int indexOf(String s1, String s2) {
		return findMatch(s1, s2, 0);
	}
	
	private static int findMatch(String s1, String s2, int index) {
		if(index+s2.length() > s1.length()) {
			return -1;
		}
		else if(s1.substring(index, index+s2.length()).equals(s2)) {
			return index;			
		}
		return findMatch(s1, s2, index+1);

}
}
