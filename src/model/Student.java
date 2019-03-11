package model;

public class Student {
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
