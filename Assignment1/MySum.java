package edu.sjsu.assignment1;

public class MySum {

	public static void main(String[] args) {
		System.out.println(getAlternatingSum(new int[] {1, 4, 9, 16, 9, 7, 4, 9, 11}));
	}

	public static int getAlternatingSum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i%2 == 0) {
				sum += arr[i];
			}
			else if(i%2 != 0) {
				sum -= arr[i];
			}
		}
		return sum;
	}
}
