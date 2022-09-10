package com.temmytechie.coursems.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="* Enter Student first name")
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@NotEmpty(message="* Enter Student last name")
	@Column(name="last_name")
	private String lastName;
	
	@Email(message = "* Enter Email")
	@Column(name="email")
	private String email;
	

	
	  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  
	  @JoinTable( name = "student_courses", joinColumns = @JoinColumn( name =
	  "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
	  name = "course_id",referencedColumnName = "id"))
	 
	
	private List<Course> courses = new ArrayList<>();
	
	public Student() 
	{
	
	}
	
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public Student(@NotEmpty(message = "* Enter Student first name") String firstName,
			@NotEmpty(message = "* Enter Student last name") String lastName,
			@Email(message = "* Enter Email") String email, List<Course> listOfCourses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courses = listOfCourses;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	

}
