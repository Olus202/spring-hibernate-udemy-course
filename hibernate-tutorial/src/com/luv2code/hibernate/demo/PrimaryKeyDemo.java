package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Create objects...");
			Student student = new Student("Ola", "Polus", "ola@mail.com");
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Save...");
			session.save(student);
			
			System.out.println("Get student...");
			session.get(Student.class, student.getId());
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
