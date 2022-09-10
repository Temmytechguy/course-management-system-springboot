package com.temmytechie.coursems.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temmytechie.coursems.entity.Student;
import com.temmytechie.coursems.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list student and return model and view
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		
		//return view of the students page
		return "students";
		
	}
	
	//create a new student 
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		
		//create student object to hold student form data
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		//student view to create a new student in html
		return "create_student";
		
	}
	
	//add a student to database
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "create_student";
		}
		studentService.saveStudent(student);
		
		//redirects to student page
		return "redirect:/students";
		
	}
	
	//edit  a student
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		
		
		
		model.addAttribute("student", studentService.getStudentById(id));
		
		//student view page to edit an existing student
		return "edit_student";
		
		
	}
	
	//handle student update form request
	
	@PostMapping("/students/{id}")
	public String updateStudent( @PathVariable Long id, 
			 @ModelAttribute("student") Student student, Model model)
	{
		
		//get student from database by Id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		
		studentService.updateStudent(existingStudent);
		
		//return the list of students view in html
		return "redirect:/students";
		
		
	}
	
	//handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudentById(id);
		
		return "redirect:/students";
	}

}
