package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;
import com.github.veeshostak.hibernate.entity.Student;

public class DeleteDemo {

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
			
			// get instructor by pk (id)
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			// delete instructor
			
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				
				// this also deletes the associated details object 
				// due to CascadeType.ALL
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}
