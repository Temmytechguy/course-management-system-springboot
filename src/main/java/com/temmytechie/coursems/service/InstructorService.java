package com.temmytechie.coursems.service;

import java.util.List;

import com.temmytechie.coursems.entity.Instructor;

public interface InstructorService {
	
	List<Instructor> getAllInstructors();
	
	Instructor saveInstructor(Instructor instructor);
	
	Instructor getInstructorById(Long id);
	
	Instructor updateInstructor(Instructor instructor);
	
	void deleteInstructorById(Long id);

}
