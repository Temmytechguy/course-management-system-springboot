package com.temmytechie.coursems.storage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.temmytechie.coursems.storage.entity.ImageData;
import com.temmytechie.coursems.storage.service.StorageService;

@RestController
@RequestMapping("/image")
public class ImageDataController {
	
	@Autowired
	private StorageService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String uploadImage(@RequestParam("image")MultipartFile file, Model model) throws IOException
	{
		String uploadImage = service.uploadImage(file);
		
		ResponseEntity<?> responseEntity =  ResponseEntity.status(HttpStatus.OK).body(uploadImage);
		
		model.addAttribute("uploadImage", file);
		
		return "displayfiles";
		
		
	}
	
	
	
	@GetMapping("/{filename}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName)
	{
		byte[] imageData = service.downloadImage(fileName);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png")).body(imageData);
	}
	
	@GetMapping("/showfiles")
	public String showfiles(Model model)
	{
		
		
		model.addAttribute("ImageData", service.listFiles());
		
		return "displayfiles";
	}

}
