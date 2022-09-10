package com.temmytechie.coursems.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	
	@GetMapping("/chatting")
	public String chatRoom()
	{
		return "groupchat";
	}
	
	
	@GetMapping("/fileserver")
	public String fileServer()
	{
		return "displayfiles";
	}
	
	@GetMapping("/uploadfile")
	public String uploadFiles()
	{
		return "uploadfile";
	}
	
	

}
