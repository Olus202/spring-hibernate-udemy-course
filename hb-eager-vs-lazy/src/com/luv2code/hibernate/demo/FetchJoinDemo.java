package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Get object...");
			int id = 1;
//			Instructor instructor = session.get(Instructor.class, id);
			
//			System.out.println("Retrive courses..." + instructor);
//			List<Course> courses = instructor.getCourses();
			
			session.close(); // courses are in memory so we can still use it after session closed
			
//			for (Course course : courses) {
//				System.out.println("courses... : " + course);
//			}
			
			
			
			System.out.println("Commit...");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			factory.close();
		}
	}

}
