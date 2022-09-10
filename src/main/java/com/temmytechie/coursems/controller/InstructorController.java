package com.temmytechie.coursems.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.temmytechie.coursems.entity.Instructor;
import com.temmytechie.coursems.service.InstructorService;

@Controller
public class InstructorController {
	
	private InstructorService instructorService;

	public InstructorController(InstructorService instructorService) {
		super();
		this.instructorService = instructorService;
	}
	
	
	//handler method to handle list student and return model and view

	@GetMapping("/instructors")
	public String listInstructors(Model model)
	{
		model.addAttribute("instructors", instructorService.getAllInstructors());
		
		//return view of the sInstructor page
		return "instructors";
	}
	
	//create a new instructor
		@GetMapping("/instructors/new")
	public String createInstructorForm(Model model)
	{
		Instructor instructor =  new Instructor();
		
		model.addAttribute("instructor", instructor);
		
		//instructor view to create a new instructor in html
		return "create_instructor";
		
	}
		
		//add a instructor to database
		@PostMapping("/instructors")
		public String saveInstructor(@Valid @ModelAttribute("instructor") Instructor instructor,BindingResult bindingResult)
		{
			if(bindingResult.hasErrors())
			{
				return "create_instructor";
			}
			
			instructorService.saveInstructor(instructor);
			//redirects to student page
			return "redirect:/instructors";
		}
		
		//edit  a student
		@GetMapping("/instructors/edit/{id}")
		public String editInstructorForm(@PathVariable Long id, Model model)
		{
			model.addAttribute("instructor", instructorService.getInstructorById(id));
			
			//instructor view page to edit an existing instructor
			return "edit_instructor";
		}
		
		//handle instructor update form request
		
		@PostMapping("/instructors/{id}")
		public String updateInstructor( @PathVariable Long id, 
				 @ModelAttribute("instructor") Instructor instructor, Model model)
		{
			
			//get instructor from database by Id
			Instructor existingInstrcutor = instructorService.getInstructorById(id);
			existingInstrcutor.setId(id);
			existingInstrcutor.setFirstName(instructor.getFirstName());
			existingInstrcutor.setLastName(instructor.getLastName());
			existingInstrcutor.setEmail(instructor.getEmail());
			existingInstrcutor.setDepartment(instructor.getDepartment());
			
			//save updated student object
			
			instructorService.updateInstructor(existingInstrcutor);
			
			//return the list of instructors view in html
			return "redirect:/instructors";
			
			
		}
		
		//handler method to handle delete student request
		@GetMapping("/instructors/{id}")
		public String deleteInstructor(@PathVariable Long id)
		{
			instructorService.deleteInstructorById(id);
			
			return "redirect:/instructors";
		}

}
