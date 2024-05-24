package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class Student {
	private final String name;
	private final Date dateOfBirth;
	private final List<String> courses;

	public Student(String name, Date dateOfBirth, List<String> courses) {
		this.name = name;
		this.dateOfBirth = new Date(dateOfBirth.getTime());

		this.courses = new ArrayList<>(courses);
	}

	public Date getDateOfBirth() {
		return new Date(dateOfBirth.getTime());
	}

	public List<String> getCourses() {
		return Collections.unmodifiableList(courses);
	}

	public String getName() {
		return name;
	}
	
}
