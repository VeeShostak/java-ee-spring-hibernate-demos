package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;


public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);	
			System.out.println(" Display Instructor: " + tempInstructor);
			
			
			// if eager fetch, all courses loaded in bg, no need to get from db
			// Call getter methods while session opened
			// loaded into mem while sesssion was opened
			System.out.println("Display Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			// option 1; Call getter methods while session opened
			// loaded lazy data while session was still opened into mem 
			System.out.println("Display Courses: " + tempInstructor.getCourses());

		}
		finally {
			
			
			session.close();
			
			factory.close();
		}
	}

}





