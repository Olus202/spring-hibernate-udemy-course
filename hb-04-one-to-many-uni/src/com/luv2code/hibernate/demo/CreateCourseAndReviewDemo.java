package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Create objects...");
			Course course1 = new Course("Extra course");
			
			System.out.println("Add reviews...");
			course1.addReview(new Review("The best course"));
			course1.addReview(new Review("Great!"));
			course1.addReview(new Review("I love it!"));
			
			System.out.println("Save...");
			session.save(course1);
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			factory.close();
		}
	}

}
