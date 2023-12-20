package com.proyect.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.backend.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	 Optional<List<Student>> findByNombre(String nombre);
	
}
