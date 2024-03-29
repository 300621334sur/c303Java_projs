package shafiq.ur.rehman.asgn2.test;
//Test Driver
import java.util.Collection;
import java.util.Scanner;

import shafiq.ur.rehman.asgn2.data.CourseCatalog;
import shafiq.ur.rehman.asgn2.data.CourseManager;
import shafiq.ur.rehman.asgn2.dto.Course;
import shafiq.ur.rehman.asgn2.dto.Professor;

//Consider this exercise to be an example of test-driven development (TDD)
//This class is a test driver for the CourseManager class
//Developers should never modify the tests to make their code work
public class LocalTester {

	private static void buildCatalog() {
	    CourseCatalog cm = new CourseManager();
		System.out.println("Building course catalog");
		try {
			// replace up to catch to add courses you are taking this term
			cm.addCourse(new Course("COMP231", "Software Development Project"));
			Professor professor = new Professor("Paula", "McMillan");
			cm.addCourse(new Course("COMP303", "Java EE Programming", professor));
			cm.addCourse(new Course("COMP304", "Wireless Programming"));
			cm.addCourse(new Course("COMP306", "Web Service Programming"));
			cm.addCourse(new Course("COMP307", "Software Security"));
			cm.addCourse(new Course("COMP309", "Data Warehousing and Data Mining"));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}

		System.out.println();
		System.out.println("Testing get all courses");
		try {
			System.out.println("Course catalog:");
			Collection<Course> courses = ((CourseManager) cm).getAllCourses();
			for (Course course : courses) {
				System.out.println(course);
			}
			System.out.println("done");
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		buildCatalog();
		//CourseCatalog cm = new CourseManager();
		CourseCatalog cm = new CourseManager().getInstance();
		System.out.println();
		System.out.println("Testing getting a course by code");
	try {
			String courseCode = "COMP303";
			System.out.println("Retrieving " + courseCode);
			System.out.println(cm.getCourse(courseCode));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		}
		try {
			String courseCode = "TEST 1234";
			System.out.println("Retrieving " + courseCode);
			System.out.println(cm.getCourse(courseCode));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("Testing adding a course");
		try {
			System.out.println("Adding TEST 1234");
			System.out.println(cm.addCourse(new Course("TEST 1234",
					"SQA and Testing")));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		try {
			System.out.println("Adding TEST 1234 again");
			System.out.println(cm.addCourse(new Course("TEST 1234",
					"Second Testing Course")));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("Testing deleting a course");
		try {
			System.out.println("Deleting COMP231");
			System.out.println(cm.deleteCourse("COMP231"));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		try {
			System.out.println("Deleting COMP231 again");
			System.out.println(cm.deleteCourse("COMP231"));
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("Testing updating a course");
		System.out.println("Updating Test 1234");
		try {
			Course course = cm.getCourse("TEST 1234");
			System.out.println("Updating course TEST 1234");
			// insert your details in the next line - you teach MISC101
			course.setProfessor(new Professor( "Shafiq", "", "Ur-Rehman") );
			// Set a title of your choice
			course.setCourseTitle("What would you teach?");
			course = cm.updateCourse(course);
			System.out.println("Updated: " + course);
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		try {
			System.out
					.println("Updating a course that does not exist: HIST 800");
			Course course = new Course("HIST 800", "History of the World");
			cm.updateCourse(course);
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("tests complete");
		//export > executable jar > Launch configuration > select file w main() > run as 'java -jar fileName.jar'
		//System.out.println(new Scanner(System.in).next());
	}
}
