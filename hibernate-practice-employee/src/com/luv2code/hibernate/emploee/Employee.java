package com.luv2code.hibernate.emploee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	public Employee() {
		
	}

	public Employee(String firtName, String lastName, String email) {
		this.firstName = firtName;
		this.lastName = lastName;
		this.company = email;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirtName() {
		return firstName;
	}

	public void setFirtName(String firtName) {
		this.firstName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firtName=" + firstName + ", lastName=" + lastName + ", company=" + company + "]";
	}
	
	
}
