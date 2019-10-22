package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			int studentId = 1;
			
			System.out.println("Get student...");
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Delete student...");
			session.delete(myStudent);
			
			System.out.println("Delete another...");
			session.createQuery("delete Student where firstName='Szczepan'").executeUpdate();
			
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

	