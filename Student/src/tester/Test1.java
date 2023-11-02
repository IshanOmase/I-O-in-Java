package tester;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;
import custom_exception.InvalidInputException;
import static utils.StudentCollectionUtils.*;
import static utils.IOUtils.*;

public class Test1 {
	public static void main(String[] args) {
	
		try(Scanner sc = new Scanner(System.in)){
			List<Student> studentList = populateList();
			Map<String, Student> studentMap = populateMap(studentList);
			boolean exit = false;
			while(!exit) {
				System.out.println("Option: 1. Display all student details. "
						+ "\n\t2. Cancel admission (Roll no required)"
						+ "\n\t3. Delete a course"
						+ "\n\t4. Store student details"
						+ "\n\t5. Store Student details based on GPA"
						+ "\n\t6. Store Stuednt details based on City"
						+ "\n\t0. Exit");
				try {
					switch (Integer.parseInt(sc.nextLine())) {
					case 1:
						studentList.stream()
						.forEach(System.out::println);
						break;
					case 2:
						System.out.println("Enter your roll no: ");
						int index = studentList.indexOf(new Student(sc.next()));
						if(index == -1) {
							throw new InvalidInputException("Invalid roll no given!");
						}
						Student ns = studentList.get(index);
						studentList.remove(index);
						System.out.println("Admission of Roll no:"+ ns.getRollNo() +" |Name: " +ns.getName() +" canceled");
						
						break;
					case 3:
						System.out.println("Enter the subject name: ");
						String s = sc.nextLine();
						Iterator<Student> iter = studentList.iterator();
						System.out.println("The following students of the course: "+ s.toUpperCase() 
											+ " have been removed");
						
						while(iter.hasNext()) {
							ns = iter.next();
							if(ns.getSubject() == Subject.valueOf(s.toUpperCase()) ) {
								System.out.println(ns);
								iter.remove();
							}
						}						
						
						break;
						/*Store student details
						i/p : subject n city
						Store passed student details(GPA > 6)  as per the specified 
						subject n city , sorted as per DoB , in a text file using buffer.*/
					case 4:
						System.out.println("Enter the subject and city: ");
						String subject = sc.nextLine();
						String city = sc.nextLine();
						storeStudentDetails(studentList,(subject+city), Subject.valueOf(subject.toUpperCase()), city);
						System.out.println("File created...");
						break;
					case 5:
						storeStudentsDetailsBasedOnGPA(studentList);
						System.out.println("File created...");
						break;
					case 6:
						System.out.println("Enter the name of the city: ");
						storeStudentDetailsBasedOnCity(studentList, sc.nextLine());
						System.out.println("File created...");
						break;
					case 0:
						exit = true;
						break;
					default:
						break;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
					
			}

		}
	}
}
