 package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			
			
//			Student myStudent = session.get(Student.class, studentId);
//			session.delete(myStudent);
			
			// delete student with id=2
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
