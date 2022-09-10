package com.temmytechie.coursems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.temmytechie.coursems.entity.Course;
import com.temmytechie.coursems.entity.Student;
import com.temmytechie.coursems.repository.CourseRepository;
import com.temmytechie.coursems.repository.StudentRepository;

@SpringBootApplication
public class CourseManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	/*
	 * @Autowired private CourseRepository courseRepository;
	 */

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Course c1 = new Course("MT104", "Pyhton for Data Science",
		 * "Learn Python modules and frameworks");
		 * 
		 * Course c2 = new Course("MT105", "Pyhton for AI",
		 * "Artificial Intelligence with python 3");
		 * 
		 * Course c3 = new Course("MT109", "Java", "Fundamentals of Java programming");
		 * 
		 * Course c4 = new Course("M255", "Java", "Building blocks of Java");
		 * 
		 * Course c5 = new Course("M256", "Java", "Software development with Java");
		 * 
		 * Course c6 = new Course("M257", "SQL", "Fundamentals of SQL programming");
		 * 
		 * Collection<Course> listCourses1 = new ArrayList<>();
		 * 
		 * listCourses1.add(c1); listCourses1.add(c2); listCourses1.add(c3);
		 * listCourses1.add(c4); listCourses1.add(c5); listCourses1.add(c6);
		 * 
		 * 
		 * 
		 * Student student1 = new Student("kenan", "Byrmo", "j_bourne67@gmail.com");
		 * student1.setCourses(listCourses1);
		 * 
		 * 
		 * 
		 * Student student2 = new Student("mathew", "smith-jones",
		 * "jsoprano@gmail.com"); student2.setCourses(listCourses1);
		 * 
		 * 
		 * Student student3 = new Student("pamela", "jenkins", "peterM23@gmail.com");
		 * student3.setCourses(listCourses1);
		 * 
		 * studentRepository.save(student3); studentRepository.save(student1);
		 * studentRepository.save(student2); studentRepository.flush();
		 * 
		 * 
		 * for(Course course:listCourses1) { courseRepository.save(course); }
		 * courseRepository.flush();
		 * 
		 */


	}

}
