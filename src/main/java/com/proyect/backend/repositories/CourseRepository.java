package com.proyect.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.backend.entities.Assistence;
import com.proyect.backend.entities.Course;
import com.proyect.backend.entities.Student;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	Optional<List<Course>> findByNombre(String nombre);
	
}
