package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Create objects...");
			Student student1 = new Student("Ola", "Polus", "ola@mail.com");
			Student student2 = new Student("Szczepan", "Polus", "ola@mail.com");
			Student student3 = new Student("Matylda", "Polus", "ola@mail.com");
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Save...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
