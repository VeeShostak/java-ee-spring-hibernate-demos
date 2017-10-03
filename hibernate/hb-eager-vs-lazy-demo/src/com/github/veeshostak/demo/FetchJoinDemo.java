package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;


public class FetchJoinDemo {

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
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses " 
									+ "where i.id=:theInstructorId",
							Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			// (our query loads instructor and courses all at once)
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println(" Display Instructor: " + tempInstructor);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("\n\nSession is closed \n\n");
			
			// option 2: Hibernate query with HQL  while session opened
			// loaded lazy data while session was still opened into mem 
			System.out.println("Display Courses: " + tempInstructor.getCourses());

		}
		finally {
			
			
			session.close();
			
			factory.close();
		}
	}

}





