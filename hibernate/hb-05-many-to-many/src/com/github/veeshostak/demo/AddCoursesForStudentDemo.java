package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;
import com.github.veeshostak.hibernate.entity.Review;
import com.github.veeshostak.hibernate.entity.Student;


public class AddCoursesForStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			
			// create a course
			Course tempCourse = new Course("Math 250 - Calculus with Analytic Geometry 3");
			// save the course
			session.save(tempCourse);
			System.out.println("Saved course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Jake", "Vi", "johnvi@aol.com");
			Student tempStudent2 = new Student("Jonathan", "Doe", "Jonathan@yahoo.com");
						
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
	}

}





