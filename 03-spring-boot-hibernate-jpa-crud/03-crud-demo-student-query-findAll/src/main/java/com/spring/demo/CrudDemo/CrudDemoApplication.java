package com.spring.demo.CrudDemo;

import com.spring.demo.CrudDemo.dao.StudentDAO;
import com.spring.demo.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			queryForStudents(studentDAO);
		};
	}



	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "paul@example.com");

		// save student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student student = new Student("John", "Doe", "john@example.com");
		Student student2 = new Student("Mary", "Public", "mary@example.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@example.com");

		// save student object
		System.out.println("Saving the students...");
		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
		System.out.println("Saved student. Generated id: " + student2.getId());
		System.out.println("Saved student. Generated id: " + student3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student
		System.out.println("Creating a student object...");
		Student student = new Student("Daffy", "Duck", "daffy@example.com");

		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// Retrieve student
		System.out.println("Retrieving student with id " + student.getId());
		Student retrievedStudent = studentDAO.findById(student.getId());

		// Display student
		System.out.println("Found the student: " + retrievedStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		System.out.println("Finding students...");
		List<Student> students = studentDAO.findAll();

		// Display list of students
		students.forEach(System.out::println);
	}

}
