package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Create objects...");
			Instructor instructor = new Instructor("Ola", "Polus", "ola@mail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube", "astrophoto");
			
			System.out.println("Association...");
			instructor.setInstructorDatail(instructorDetail);
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Save...");
			session.save(instructor);
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
