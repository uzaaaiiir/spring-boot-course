package com.springboot.mappingsdemo;

import com.springboot.mappingsdemo.dao.AppDAO;
import com.springboot.mappingsdemo.entity.Course;
import com.springboot.mappingsdemo.entity.Instructor;
import com.springboot.mappingsdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MappingsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingsDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@example.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube", "Playing Guitar"
		);

		instructor.setInstructorDetail(instructorDetail);


		// Save instructor
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Instructor saved.");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor with id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor found: " + instructor);
		System.out.println("Instructor details: " + instructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleted instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Deleted instructor.");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor detail with id " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 4;

		System.out.println("Deleting instructor detail with id " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done.");
	}


	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan", "Public", "susan@example.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.youtube.com", "Video Games"
		);
		instructor.setInstructorDetail(instructorDetail);

		// Create courses
		Course course1 = new Course("Biology - General Biology");
		Course course2 = new Course("Introduction to Computer Science");

		// Add courses to instructor
		instructor.add(course1);
		instructor.add(course2);

		// Save instructor
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Instructor saved.");
	}


	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor " + instructor);
		System.out.println("Courses " + instructor.getCourses());
		System.out.println("Done.");
	}


	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor " + instructor);

		// Find courses for instructor
		System.out.println("Finding courses for the instructor...");
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("Courses " + instructor.getCourses());
		System.out.println("Done.");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor id " + id);
		Instructor instructor  = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor " + instructor);
		System.out.println("Associated Courses: " + instructor.getCourses());
		System.out.println("Done.");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor id " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor id " + id);
		instructor.setLastName("TESTER");

		appDAO.update(instructor);
		System.out.println("Done.");
	}

	private void updateCourse(AppDAO appDAO) {
		int courseId = 10;

		System.out.println("Finding course id: " + courseId);
		Course course = appDAO.findCourseById(courseId);

		System.out.println("Updating course id: " + courseId);
		course.setTitle("Databases - Spring JPA");

		appDAO.update(course);
		System.out.println("Done.");
	}


	private void deleteCourse(AppDAO appDAO) {
		int courseId = 10;

		System.out.println("Deleting course id " + courseId);

		appDAO.deleteCourseById(courseId);
		System.out.println("Done.");
	}

}