package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Query...");
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			System.out.println("Results...");
			for (Student student : theStudents) {
				System.out.println(student);
			}
			
			System.out.println("Query...");
			List<Student> theStudents2 = session.createQuery("from Student s where s.lastName = 'Polus'").getResultList();
			
			System.out.println("Results...");
			for (Student student : theStudents2) {
				System.out.println(student);
			}
			
			System.out.println("Query...");
			List<Student> theStudents3 = session.createQuery("from Student s where s.firstName = 'Ola' OR s.lastName = 'Matylda'").getResultList();
			
			System.out.println("Results...");
			for (Student student : theStudents3) {
				System.out.println(student);
			}
			
			System.out.println("Query...");
			List<Student> theStudents4 = session.createQuery("from Student s where s.firstName LIKE '%lda'").getResultList();
			
			System.out.println("Results...");
			for (Student student : theStudents4) {
				System.out.println(student);
			}
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}

	