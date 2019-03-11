package ui;

import java.io.IOException;

import model.Course;

public class Main {

	public static void main(String[] args) throws IOException {
		Course c = new Course();
		c.loadStudentsFile("data/students.txt", ";");
		System.out.println(c.getReport());
		
		
		c.printReport("data/studentsReport.txt");
	}

}
