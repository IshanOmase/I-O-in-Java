package com.app.core;

import java.time.LocalDate;

public class Student{

	
	private String rollNo;
	private String name;
	private LocalDate dob;
	private Subject subject;
	private double gpa;
	private  Address address;

	public Student(String rollNo, String name, LocalDate dob, Subject subject, double gpa) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.subject = subject;
		this.gpa = gpa;
	}
	
	
	public Student(String rollNo) {
		super();
		this.rollNo = rollNo;
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student) {
			return this.rollNo.equals(((Student) obj).rollNo);
		}
		return false;
	}
	
	
	
	@Override
	public String toString() {
		return "Student rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + ", subject=" + subject + ", gpa=" + gpa
				+ " adr : " + address;
	}

	public String getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Subject getSubject() {
		return subject;
	}

	public double getGpa() {
		return gpa;
	}
	
	public Address getAddress() {
		return address;
	}


	public void assignAddress(Address a) {
		address = a;
	}

}
