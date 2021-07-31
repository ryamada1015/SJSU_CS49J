package edu.sjsu.assignment4;

public class Student implements Comparable<Student>{

	private int id;
	private String name;
	
	public Student(int id) {
		this.id = id;
		name = "Unnamed";
	}
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.id + "." + this.name + ": ";
	}

	@Override
	public int compareTo(Student s) {
		if(id < s.id)
			return -1;
		else if(id > s.id)
			return 1;
		else
			return 0;
	}
}
