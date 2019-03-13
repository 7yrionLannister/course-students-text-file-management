package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Course;
import model.Student;

public class Main {

	public static void main(String[] args) {
		Course c = new Course(Course.PATH_FILE);
		try {
			c.loadStudentsFile("data/students.txt", ";");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(c.getReport());
		Scanner s = new Scanner(System.in);
		
		try {
			c.printReport("data/studentsReport.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int opt =-10;
		while(opt != 5) {
			System.out.println("1. Add Student");
			System.out.println("2. Generate Report");
			System.out.println("3. Import from text file");
			System.out.println("4. Export to text file");
			System.out.println("5. Exit");
			opt = s.nextInt();
			switch(opt) {
			case 1:
				System.out.println("Code:");
				String code = s.next();
				System.out.println("Semester:");
				int semes = s.nextInt();
				System.out.println("Average:");
				double ave = s.nextDouble();
				System.out.println("Conditional enrollment");
				boolean ce = s.nextBoolean();
				c.getStudents().add(new Student(code, semes, ave, ce));
				break;
			case 2:
				System.out.println(c.getReport());
				break;
			case 3:
				c = new Course(Course.PATH_FILE);
				break;
			case 4:
				c.save();
				break;
			default:
				System.out.println("Wrong option");
				break;
			}
		}
	}

}
