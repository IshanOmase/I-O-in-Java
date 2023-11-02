package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.app.core.Student;
import com.app.core.Subject;

public interface IOUtils {
	
	static void storeStudentDetails(List<Student> list, String filename, Subject sub, String city) throws IOException{
		/*
		 * process data n store it in file using buffer
		 * */
		
		try(PrintWriter pw = new PrintWriter(filename+".txt")){
			list.stream()
			.filter(s -> s.getSubject() == sub)
			.filter(s -> s.getAddress().getCity().equals(city))
			.filter(s -> s.getGpa()>5)
			.sorted((s1,s2) -> s1.getDob().compareTo(s2.getDob()))
			.forEach(pw::println);
		}
	}
	
	static void storeStudentsDetailsBasedOnGPA(List<Student> list) throws IOException {
		try(PrintWriter pw = new PrintWriter("Studentdetails.txt")){
			list.stream()
			.sorted((s1,s2) -> ((Double) s2.getGpa()).compareTo(s1.getGpa()))
			.forEach(pw::println);
			
		}
	}
		
	static void storeStudentDetailsBasedOnCity(List<Student> list, String city) throws IOException {	
		try(PrintWriter pw = new PrintWriter("studentof"+ city+".txt")){
			list.stream()
			.filter(s -> s.getAddress().getCity().equals(city))
			.forEach(pw::println);
		}
	}
		
}


