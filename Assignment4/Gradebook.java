package edu.sjsu.assignment4;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Gradebook {

	public static void main(String[] args) {

		Gradebook grades = new Gradebook();
		grades.addStudent(0, "Keith", 'B');
		grades.addStudent(1, "May");
		grades.addStudent(2, "Lily", 'A');
		grades.addStudent(0, "Keith");
		grades.addStudent(3, "Sammy", 'A');
		grades.addStudent(4, "Jessie");
		
		if(grades.deleteStudent(2))
			System.out.println("deleted");
		
		grades.printGrade(null);
		
		
	}
	
	private Map<Student, Character> map;
	
	public Gradebook() {
		this.map = new TreeMap<Student, Character>();
	}
	
	public Map<Student, Character> getStudent(){
		return this.map;
	}

	public boolean addStudent(int id, String name, char grade) {
		Iterator<Entry<Student, Character>> it = map.entrySet().iterator();
		
		Student student = getStudentById(it, id);
		if(student == null) {
			map.put(new Student(id, name), Character.valueOf(grade));
			return true;
		}
		else if(!(grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F')) {
			grade = 'N';
			return true;
		}
		return false;
//		while(it.hasNext()) {
//			Entry<Student, Character> en = it.next();
//			if(en.getKey().getId() == id) {
//				System.out.println("Already exists.");
//				return false;
//			}
//			else if(!(grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F')) {
//				grade = 'N';
//				return true;
//			}
//		}
//		map.put(new Student(id, name), Character.valueOf(grade));
//		return true;
	}
	
	public boolean addStudent(int id, String name) {
		Iterator<Entry<Student, Character>> it = map.entrySet().iterator();

	Student student = getStudentById(it, id);
	if(student == null) {
		map.put(new Student(id, name), 'N');
		return true;
	}
	return false;
	
//		while(it.hasNext()) {
//			Entry<Student, Character> en = it.next();
//			if(en.getKey().getId() == id) {
//				System.out.println("Already exists.");
//				return false;
//			}
//		}
//		map.put(new Student(id, name), 'N');
	}
	
	public boolean deleteStudent(int id) {
		Iterator<Entry<Student, Character>> it = map.entrySet().iterator();

		Student student = getStudentById(it, id);
		if(student != null) {
			map.remove(student);
			return true;
		}
		return false;
		
	}
	
	public boolean updateGrade(int id, char newGrade) {
		if(!(newGrade == 'A' || newGrade == 'B' || newGrade == 'C' || newGrade == 'D' || newGrade == 'F')) 
			return false;
		
		Iterator<Entry<Student, Character>> it = map.entrySet().iterator();

		Student student = getStudentById(it, id);
		if(student != null) {
			map.remove(student);
			map.put(student, Character.valueOf(newGrade));
			return true;
		}
		return false;
	}
	
	public void printGrade(Comparator<Student> comparator) {
		if(comparator == null) {
			for(Map.Entry<Student, Character> el : map.entrySet()) {
				System.out.println(el.getKey().toString());
			}
		}
	}
	
	public Student getStudentById(Iterator<Entry<Student, Character>> it, int id) {
		while(it.hasNext()) {
			Entry<Student, Character> en = it.next();
			if(en.getKey().getId() == id) {
				return en.getKey();
			}
		}
		return null;
	}
	
}
