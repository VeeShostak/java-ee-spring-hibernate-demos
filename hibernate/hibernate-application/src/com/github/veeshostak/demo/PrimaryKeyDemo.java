package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create student object
			Student tempStudent1 = new Student("Mark", "Smith", "Mark@google.com");
			// start transaction
			session.beginTransaction();
			// save student object
			session.save(tempStudent1);
			// commit transaction
			session.getTransaction().commit();
			
			// print student's generated id
			System.out.println("student id: " + tempStudent1.getId());
			
			// =========
			// Retrieve student based on id (pk)
			
			// start session, begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, tempStudent1.getId());
			session.getTransaction().commit();
			
			System.out.println("Retrieved student's info:\n" + myStudent);
			
		}
		finally {
			factory.close();
		}

	}

}
