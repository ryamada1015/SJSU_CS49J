package edu.sjsu.assignment3;

import java.time.LocalDate;

public class OnetimeAppointment extends Appointment {

	public OnetimeAppointment(String description, LocalDate date) {
		super(description, date, date);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean occursOn(LocalDate date) {
		if(date.equals(this.getStartDate()) && date.equals(this.getEndDate()))
			return true;
		return false;
	}

}
