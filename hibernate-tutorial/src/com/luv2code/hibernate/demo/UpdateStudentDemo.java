package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			System.out.println("Update student...");
			myStudent.setFirtName("Matylda");
			
			System.out.println("Query...");
			session.createQuery("update Student set email='ola@gmail.com'").executeUpdate();
			
//			System.out.println("Results...");
//			for (Student student : theStudents4) {
//				System.out.println(student);
//			}
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

	