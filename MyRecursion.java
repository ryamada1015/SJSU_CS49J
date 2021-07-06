package edu.sjsu.assignment2;

public class MyRecursion {

	public static void main(String[] args) {
		System.out.println(indexOf("mississippi", "sip"));
	}
	
	public static int indexOf(String s1, String s2) {
		return findMatch(s1, s2, 0, 0);
	}
	
	private static int findMatch(String s1, String s2, int pos1, int pos2) {
		
		//if match not found
		if(pos1 == s1.length()) return -1;
		else if(pos2 == s2.length()) return pos1-s2.length();
		else if(s1.charAt(pos1) != s2.charAt(pos2) && pos2 > 0 && pos2 < s2.length())
			return findMatch(s1, s2, pos1-pos2+1, 0);
		else if(s1.charAt(pos1) != s2.charAt(pos2) && pos2 == 0)
			return findMatch(s1, s2, pos1+1, pos2);
		else if (s1.charAt(pos1) == s2.charAt(pos2)) 
			return findMatch(s1, s2, pos1+1, pos2+1);
		return pos1-s2.length();
		
}
}
