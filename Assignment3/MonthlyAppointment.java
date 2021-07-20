package edu.sjsu.assignment3;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment {

	public MonthlyAppointment(String description, LocalDate startDate, LocalDate endDate) {
		super(description, startDate, endDate);
	}
	
	@Override 
	public boolean occursOn(LocalDate date) {
		if(date.isAfter(this.getStartDate().minusDays(1)) && date.isBefore(this.getEndDate().minusDays(1)) && date.getDayOfMonth() == this.getStartDate().getDayOfMonth())
			return true;
		return false;
	}

}
