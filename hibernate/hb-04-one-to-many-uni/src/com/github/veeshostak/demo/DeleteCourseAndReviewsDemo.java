package com.github.veeshostak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.github.veeshostak.hibernate.entity.Course;
import com.github.veeshostak.hibernate.entity.Instructor;
import com.github.veeshostak.hibernate.entity.InstructorDetail;
import com.github.veeshostak.hibernate.entity.Review;


public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the course
			int theId = 10;
			// only gets course due to lazy fetch
			Course tempCourse = session.get(Course.class, theId);
			
			// course
			System.out.println(tempCourse);
			// course reviews
			System.out.println(tempCourse.getReviews());
			
			// cascades and deletes all reviews
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





