package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Course {
	public final static String PATH_FILE = "data/course.dafr";
	private List<Student> students;
	
	public Course(String archi) {
		File archivo = new File(archi);
		if(archivo.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				students = (ArrayList)ois.readObject();
				ois.close();
			}
			catch(Exception e) {
				
			}
		}
		else {
			students = new ArrayList<>();
		}
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
	
	public void save() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH_FILE));

			oos.writeObject(students);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents() {
		return students;
	}
}
