package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;
import com.github.veeshostak.hibernate.entity.Review;
import com.github.veeshostak.hibernate.entity.Student;

public class DeleteStudentDemo {

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

			// get student from db
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			// delete the student
			System.out.println("Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}