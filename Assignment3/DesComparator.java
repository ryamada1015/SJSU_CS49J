package edu.sjsu.assignment3;

import java.util.Comparator;

public class DesComparator implements Comparator<Appointment> {

	@Override
	public int compare(Appointment a1, Appointment a2) {
		if(a1.getStartDate().isBefore(a2.getStartDate()))
			return -1;
		else if(a1.getStartDate().equals(a2.getStartDate()) && a1.getEndDate().isBefore(a2.getEndDate()))
			return -1;
		else if(a1.getStartDate().equals(a2.getStartDate()) && a1.getEndDate().equals(a2.getEndDate()) && a1.getDescription().compareTo(a2.getDescription()) < 0)
			return -1;
		return 1;
	}
}
