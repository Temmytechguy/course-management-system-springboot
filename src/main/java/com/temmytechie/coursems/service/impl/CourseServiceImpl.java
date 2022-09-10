package com.temmytechie.coursems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temmytechie.coursems.entity.Course;
import com.temmytechie.coursems.repository.CourseRepository;
import com.temmytechie.coursems.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	private CourseRepository courseRepository;
	
	

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		
		return courseRepository.save(course);
	}

	@Override
	public Course getCourseById(Long id) {
		
		return courseRepository.findById(id).get();
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourseById(Long id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
		
	}

}
