package com.github.veeshostak.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;


public class DeleteInstructorDetailDemo {

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

			// get instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// Display
			// the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);	
			// the associated instructor
			System.out.println("the associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			// remove the associated object reference if not cascading on delete
			// break the bidirectional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// delete the instructor detail 
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}



