package edu.sjsu.assignment3;

import java.time.LocalDate;

public class DailyAppointment extends Appointment{

	public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
		super(description, startDate, endDate);
	}

	@Override
	public boolean occursOn(LocalDate date) {
		if(date.isAfter(this.getStartDate().minusDays(1)) && date.isBefore(this.getEndDate().plusDays(1)))
			return true;
		return false;
	}
}
