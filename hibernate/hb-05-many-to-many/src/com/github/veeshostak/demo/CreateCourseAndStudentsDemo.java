package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;
import com.github.veeshostak.hibernate.entity.Review;
import com.github.veeshostak.hibernate.entity.Student;


public class CreateCourseAndStudentsDemo {

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
			
			// get the student Jonathan from db
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\n student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			// create more courses 
			Course tempCourse1 = new Course("Java - OOP");
			Course tempCourse2 = new Course("Angular4 - Complete Guide");
						
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
						
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
						
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
	}

}





