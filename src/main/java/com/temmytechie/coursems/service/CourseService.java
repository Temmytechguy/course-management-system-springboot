package com.temmytechie.coursems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temmytechie.coursems.entity.Course;


public interface CourseService {
	
	List<Course> getAllCourses();
	
	Course saveCourse(Course course);
	
	Course getCourseById(Long id);
	
	Course updateCourse(Course course);
	
	void deleteCourseById(Long id);

}
