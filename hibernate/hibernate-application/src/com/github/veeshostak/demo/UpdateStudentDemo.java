package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Update student object
			
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("student id: " + studentId);
			
			// retrieve persistent object (no need to save just commit)
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Jake");
			session.getTransaction().commit();
			
			
			// =====
			// new transaction. update email of alll students
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='test@outlook.com'")
					.executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
	}

}
