package com.temmytechie.coursems.storage.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.temmytechie.coursems.storage.entity.ImageData;
import com.temmytechie.coursems.storage.entity.ImageDataBuilder;
import com.temmytechie.coursems.storage.repository.StorageRepository;
import com.temmytechie.coursems.storage.util.Utils;

@Service
public class StorageService {
	
	
	
	@Autowired
	private StorageRepository repository;
	
	public String uploadImage(MultipartFile file) throws IOException
	{
		ImageData imageData = repository.save(ImageDataBuilder.builder()
				.addName(file.getOriginalFilename())
				.addType(file.getContentType())
				.addImageData(Utils.compressImage(file.getBytes())).build());
		
		if(imageData != null)
		{
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		
		 return "redirect:/displayfiles";
		
			
	}
	
	public byte[] downloadImage(String fileName)
	{
		Optional<ImageData> dbOptional = repository.findByName(fileName);
		
		byte[] images = Utils.decompressImage(dbOptional.get().getImageData());
		
		return images;
	}
	
	public List<ImageData> listFiles()
	{
		return repository.findAll();
	}

}
