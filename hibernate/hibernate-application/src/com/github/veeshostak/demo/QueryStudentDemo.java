package com.github.veeshostak.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			
			// start transaction
			session.beginTransaction();
			
			// query all students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display students
			displayStudents(theStudents);
			
			
			// query students: fistName=John
			theStudents = session.createQuery("from Student s where s.firstName='John'").list();
			
			System.out.println("students with first name John:\n");
			displayStudents(theStudents);
			
			
			// query students: lastname=Smith OR fistName=Mike
			theStudents = session.createQuery("from Student s where "
									+ "s.lastName='Smith' OR s.firstName='Mike'").list();
			
			System.out.println("students with: lastname=Smith OR fistName=Mike:\n");
			displayStudents(theStudents);
			
			
			// query students: email LIKE  %google.com (ends with google.com)
			theStudents = session.createQuery("from Student s where "
									+ "s.email LIKE '%google.com'").list();
			
			System.out.println("students with: a google email:\n");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
