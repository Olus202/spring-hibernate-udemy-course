package com.luv2code.hibernate.emploee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Create object...");
			Employee emp = new Employee("Ola", "Polus", "Nokia");
			
			System.out.println("Transaction...");
			session.beginTransaction();
			
			System.out.println("Save...");
			session.save(emp);
			
			System.out.println("Retrieve...");
			Employee emp2 = session.get(Employee.class, emp.getId());
			
			System.out.println("Update...");
			emp2.setFirtName("Matylda");
			
			System.out.println("Query...");
			List<Employee> list = session.createQuery("from Employee").getResultList();
			
			System.out.println("Results...");
			for (Employee e : list) {
				System.out.println(e);
			}
			
			System.out.println("Commit...");
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
