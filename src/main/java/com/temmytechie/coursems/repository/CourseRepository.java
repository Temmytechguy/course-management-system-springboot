package com.temmytechie.coursems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temmytechie.coursems.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
