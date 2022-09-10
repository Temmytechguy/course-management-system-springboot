package com.temmytechie.coursems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temmytechie.coursems.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
