package com.proyect.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.backend.entities.Assistence;
import com.proyect.backend.entities.Student;


public interface AssistenceRepository  extends JpaRepository<Assistence, Integer> {

	Optional<List<Assistence>> findByNota(Integer nota);
}
