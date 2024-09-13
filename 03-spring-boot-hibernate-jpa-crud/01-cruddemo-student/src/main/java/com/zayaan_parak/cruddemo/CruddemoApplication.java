package com.zayaan_parak.cruddemo;

import com.zayaan_parak.cruddemo.dao.StudentDAO;
import com.zayaan_parak.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students

		System.out.println("Creating Student Objects...");
		Student student1 = new Student("Zayaan", "Parak", "zayboy789@gmail.com");
		Student student2 = new Student("Werner", "Janse Van Rensburg", "werner789@gmail.com");
		Student student3 = new Student("Simphiwe", "Nkgau", "simphiwe@gmail.com");
		Student student4 = new Student("Nksoi", "Kubeka", "nkosi789@gmail.com");


		// save the student objects

		System.out.println("Saving Student Objects...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		studentDAO.save(student4);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating Student Object...");
		Student student = new Student("Zayaan", "Parak", "zayboy789@gmail.com");

		//save the student object
		System.out.println("Saving Student...");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved Student. Generated ID: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object

		System.out.println("Creating Student Object...");
		Student student = new Student("Qailaah", "Parak", "qparak786@gmail.com");


		// save student object

		System.out.println("Saving Student Object...");
		studentDAO.save(student);


		// display id of saved student

		System.out.println("Saved Student. Generated with id: " + student.getId());


		// retrieve student based on id: primary key

		System.out.println("\nRetrieving Student with ID: " + student.getId());
		Student foundStudent = studentDAO.findById(student.getId());

		System.out.println("Found the student: " + foundStudent);
	}

	private void queryForStudents(StudentDAO studentDAO){

		// retrieve list of students

		List<Student> students = studentDAO.findAll();


		// display list of students

		for (Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		// get a list of students

		List<Student> students = studentDAO.findByLastName("Janse Van Rensburg");


		// display list of students with last name

		for (Student student : students){
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO){

		// retrieve student based on ID: primary key
		int studentId = 1;
		System.out.println("Retrieving Student by ID: " + studentId);

		Student student = studentDAO.findById(studentId);

		System.out.println("Updating Student...");


		// change first name to Zayboy

		student.setFirstName("Zayboy");
		studentDAO.update(student);


		// display updated student
		System.out.println("Updated Student: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO){

		// delete student based on ID: primary key

		int studentId = 7;

		System.out.println("Deleting Student with ID: " + studentId);


		// delete student

		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting All Students...");

		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " Rows of Students.");
	}
}
