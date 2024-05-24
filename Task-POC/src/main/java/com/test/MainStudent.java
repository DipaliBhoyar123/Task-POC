package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainStudent {

	public static void main(String[] args) {

		Date dateOfBirth = new Date();

		List<String> courses = new ArrayList<>();
		courses.add("Mathematics");
		courses.add("Physics");

		Student student = new Student("John Doe", dateOfBirth, courses);

		System.out.println("Name of Student: " + student.getName());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
		System.out.println("Courses: " + student.getCourses());

		dateOfBirth.setTime(0);
		courses.add("Chemistry");

		System.out.println("After external modification attempts:");
		System.out.println("Name of Student: " + student.getName());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
		System.out.println("Courses: " + student.getCourses());

		Date studentDob = student.getDateOfBirth();
		studentDob.setTime(0);
		List<String> studentCourses = student.getCourses();
		try {
			studentCourses.add("Biology");
		} catch (UnsupportedOperationException e) {
			System.out.println("Caught UnsupportedOperationException when trying to modify courses list");
		}

		System.out.println("After internal modification attempts:");
		System.out.println("Name of Student: " + student.getName());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
		System.out.println("Courses: " + student.getCourses());
	}
}
