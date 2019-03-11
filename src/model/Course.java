package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private List<Student> students;
	
	public Course() {
		students = new ArrayList<>();
	}
	
	public void loadStudentsFile(String path, String sep) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split(sep);
			
			String code = parts[0];
			int semester = Integer.parseInt(parts[1]);
			double av = Double.parseDouble(parts[2]);
			boolean ce = Boolean.parseBoolean(parts[3]);
			
			Student s = new Student(code, semester, av, ce);
			students.add(s);
			
			line = br.readLine();
		}
		
		br.close();
		fr.close();
	}
	
	public String getReport() {
		String msg = "The students are:\n";
		msg += "CODE\tSEMESTER\tAVERAGE\tCONDITIONAL ENROLLMENT\n";
		for (int i = 0; i < students.size(); i++) {
			Student current = students.get(i);
			msg += current.getCode()+"\t"+current.getSemester()+"\t"+current.getAverage()+"\t"+current.getConditionalEnrollment()+"\n";
		}
		return msg;
	}
	
	public void printReport(String path) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		
		String repStr = getReport();
		pw.print(repStr);
		
		pw.close();
	}
	
}
