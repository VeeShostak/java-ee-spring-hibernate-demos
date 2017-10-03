package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;



public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
						
			// the associated instructor
			System.out.println("associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak  after null pointer exception to exit gracefully
			session.close();
			factory.close();
		}
	}

}





