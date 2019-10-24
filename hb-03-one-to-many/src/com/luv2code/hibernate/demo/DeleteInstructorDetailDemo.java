package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();

			System.out.println("Get...");
			int id = 3;
			InstructorDetail instDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("details: " + instDetail);
			
			System.out.println("instructor: " + instDetail.getInstructor());
			
			System.out.println("Delete it...");
			instDetail.getInstructor().setInstructorDatail(null);
			session.delete(instDetail);
			
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
