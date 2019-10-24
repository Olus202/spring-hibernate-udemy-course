package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateCoursesDemo {

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
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Create objects...");
			Course course1 = new Course("course1");
			Course course2 = new Course("course2");
			
			System.out.println("Add courses...");
			instructor.add(course1);
			instructor.add(course2);
			
			System.out.println("Save...");
			session.save(course1);
			session.save(course2);
			
			System.out.println("Commit...");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
