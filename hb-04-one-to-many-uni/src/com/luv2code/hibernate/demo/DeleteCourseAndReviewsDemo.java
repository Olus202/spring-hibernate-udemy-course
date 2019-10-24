package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteCourseAndReviewsDemo {

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
			
			System.out.println("Get course...");
			int id =10;
			Course course = session.get(Course.class, id);

			System.out.println("Delete...");
			session.delete(course);
			
			System.out.println("Get reviews...");
//			System.out.println(course.getReviews());
			
			System.out.println("Save...");
			
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
