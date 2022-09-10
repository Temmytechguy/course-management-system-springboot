package com.temmytechie.coursems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temmytechie.coursems.entity.Instructor;
import com.temmytechie.coursems.repository.InstructorRepository;
import com.temmytechie.coursems.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	private InstructorRepository instructorRepository;
	
	

	public InstructorServiceImpl(InstructorRepository instructorRepository) {
		super();
		this.instructorRepository = instructorRepository;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) {
		
		return instructorRepository.save(instructor);
	}

	@Override
	public Instructor getInstructorById(Long id) {
		return instructorRepository.findById(id).get();
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@Override
	public void deleteInstructorById(Long id) {
		
		instructorRepository.deleteById(id);
		
	}

}
