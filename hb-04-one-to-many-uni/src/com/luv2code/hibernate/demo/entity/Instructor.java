package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firtName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDatail;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor", cascade= {CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH})
	private List<Course> courses;
	
	public Instructor() {
		
	}

	public Instructor(String firtName, String lastName, String email) {
		this.firtName = firtName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirtName() {
		return firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDatail() {
		return instructorDatail;
	}

	public void setInstructorDatail(InstructorDetail instructorDatail) {
		this.instructorDatail = instructorDatail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void add(Course course) {
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(course);
		course.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firtName=" + firtName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDatail=" + instructorDatail + "]";
	}
	
	
}
