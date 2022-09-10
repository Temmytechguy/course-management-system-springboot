package com.temmytechie.coursems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temmytechie.coursems.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>
{

	
}
