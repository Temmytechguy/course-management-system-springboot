package com.temmytechie.coursems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.temmytechie.coursems.entity.Course;
import com.temmytechie.coursems.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping("/courses")
	public String listCourses(Model model)
	{
		model.addAttribute("courses", courseService.getAllCourses());
		
		return "courses";
		
	}
	
	
	//create a new course 
	@GetMapping("/courses/new")
	public String createCourseForm(Model model)
	{
		Course course = new Course();
		
		model.addAttribute("course", course);
		
		//course view to create a new course in html
		return "create_course";
	}
	
	//add a course to database
	@PostMapping("/courses")
	public String saveCourse(@Valid @ModelAttribute("course")Course course,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "create_course";
		}
		courseService.saveCourse(course);
		
		//redirects to course page
		return "redirect:/courses";
	}
	
	//edit  a course
	@GetMapping("/courses/edit/{id}")
	public String editCourseForm(@PathVariable Long id, Model model) 
	{
		model.addAttribute("course", courseService.getCourseById(id));
		
		//course view page to edit an existing course
		return "edit_course";
	}
	
	
	//handle course  update form request
	@PostMapping("/courses/{id}")
	public String updateCourse(@PathVariable Long id, @ModelAttribute("course")Course course, Model model)
	{
		//get course from database by Id
		Course existingCourse = courseService.getCourseById(id);
		
		existingCourse.setId(id);
		existingCourse.setCourseCode(course.getCourseCode());
		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setCourseDescription(course.getCourseDescription());
		
		//save updated course object
		
		courseService.saveCourse(existingCourse);
		
		//return the list of courses view in html
		return "redirect:/courses";
		
		
	}
	
	//handler method to handle delete course request
	@GetMapping("/courses/{id}")
	public String deleteCourse(Long id)
	{
		courseService.deleteCourseById(id);
		
		return "redirect:/courses";
	}
	

}
