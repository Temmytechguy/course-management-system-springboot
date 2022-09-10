package com.temmytechie.coursems.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.temmytechie.coursems.security.service.UserService;
import com.temmytechie.coursems.security.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registrations")
public class UserRegistrationController {
	
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//returns a new object of user registrationDto
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto()
	{
		
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm()
	{
		
		return "registrations";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto)
	{
		userService.save(userRegistrationDto);
		return "redirect:/registrations?success";
		
		
		
	}
	
	
 
}
