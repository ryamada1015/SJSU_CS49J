package edu.sjsu.assignment3;

import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public Appointment(String description, LocalDate startDate, LocalDate endDate) {
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	public abstract boolean occursOn(LocalDate date);
	
	@Override 
	public int compareTo(Appointment appointment) {
		if(appointment.getStartDate().isBefore(this.getStartDate()))
			return 1;
		else if(appointment.getStartDate().equals(this.getStartDate()) && appointment.getEndDate().isBefore(this.getEndDate()))
			return 1;
		else if(appointment.getStartDate().equals(this.getStartDate()) && appointment.getEndDate().equals(this.getEndDate()) && appointment.getDescription().compareTo(this.getDescription()) < 0)
			return 1;
		return -1;
	
	}
	
	@Override 
	public String toString() {
		return description + "Start Date: " + startDate + " End Date: " + endDate + "\n";
	}

}
