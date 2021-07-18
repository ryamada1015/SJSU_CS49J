package edu.sjsu.assignment1;

public class MyTime {

	public static void main(String[] args) {
		printTimeDifference("0120", "1510");
		printTimeDifference("1635", "0250");

	}
	
	public static void printTimeDifference(String time1, String time2) {	
		int min1 = Integer.parseInt(time1.substring(2));
		int min2 = Integer.parseInt(time2.substring(2));
		int hour1 = Integer.parseInt(time1.substring(0,2));
		int hour2 = Integer.parseInt(time2.substring(0,2));

		int hourDiff = 0;
		int minDiff = 0;
		
		if(hour1 < hour2 && min1 > min2) {
			hourDiff = hour2 - hour1 - 1;
			minDiff = 60 - (min1 - min2);
		}
		else if(hour1 <= hour2 && min1 <= min2) {
			hourDiff = hour2 - hour1;
			minDiff = min2 - min1;
		}
		else if(hour1 >= hour2 && min1 > min2) {
			hourDiff = 24 - (hour1 - hour2) - 1;
			minDiff = 60 - (min1 - min2);
		}
		else if(hour1 > hour2 && min1 <= min2) {
			hourDiff = 24 - (hour1 - hour2);
			minDiff = min2 - min1;
		}
		

		System.out.println(hourDiff + " hour(s) " + minDiff + " minute(s)");
		
	}

}
