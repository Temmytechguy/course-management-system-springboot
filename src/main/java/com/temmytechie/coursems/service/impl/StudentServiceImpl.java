package com.temmytechie.coursems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.temmytechie.coursems.entity.Student;
import com.temmytechie.coursems.repository.StudentRepository;
import com.temmytechie.coursems.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}




	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}




	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}




	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
		
	}




	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}




	@Override
	public void deleteStudentById(long id) {
		
		studentRepository.deleteById(id);
		
	}
	
	

}
