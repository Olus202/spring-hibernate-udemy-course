package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Create objects...");
			Course course1 = new Course("Extra course 2");
			
			System.out.println("Save...");
			session.save(course1);
			
			System.out.println("Create Students...");
			Student student1 = new Student("Ola", "Polus", "email3");
			Student student2 = new Student("Matylda", "Polus", "email6");
			
			System.out.println("Add Students...");
			course1.addStudent(student1);
			course1.addStudent(student2);
			
			System.out.println("Save...");
			session.save(student1);
			session.save(student2);
			
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
