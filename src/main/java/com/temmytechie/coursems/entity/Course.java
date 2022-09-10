package com.temmytechie.coursems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String courseCode;
	
	
	
	private String courseName;
	
	
	
	private String courseDescription;
	
	

	public Course() {
		super();
	}



	public Course(String code, String name, String description) {
		super();
		this.courseCode = code;
		this.courseName = name;
		this.courseDescription = description;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCourseCode() {
		return courseCode;
	}



	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getCourseDescription() {
		return courseDescription;
	}



	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}




	
	
	
	
	
	
	

}
