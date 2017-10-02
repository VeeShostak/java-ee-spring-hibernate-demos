package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Student tempStudent = new Student("John", "Smith", "John@google.com");
			
			// start transaction
			session.beginTransaction();
			// save student object
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
