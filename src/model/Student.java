package model;

import java.io.Serializable;

public class Student implements Serializable {
	private String code;
	private int semester;
	private double average; //accumulatedAverage
	private boolean conditionalEnrollment;
	
	public Student(String c, int s, double a, boolean ce) {
		code = c;
		semester = s;
		average = a;
		conditionalEnrollment = ce;
	}

	public String getCode() {
		return code;
	}

	public int getSemester() {
		return semester;
	}

	public double getAverage() {
		return average;
	}
	
	public boolean getConditionalEnrollment() {
		return conditionalEnrollment;
	}
	
}
