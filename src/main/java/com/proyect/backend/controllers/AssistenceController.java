package com.proyect.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.backend.entities.Assistence;

import com.proyect.backend.repositories.AssistenceRepository;


@RestController
@RequestMapping("/assis")
@CrossOrigin
public class AssistenceController {

	@Autowired
	AssistenceRepository assistenceRepository;
	
	@GetMapping("/listar")
	public List<Assistence> listar(){
		return assistenceRepository.findAll();
	}
	
	 @GetMapping("/nota={nota}")
	    public Optional<List<Assistence>> findByNota(@PathVariable Integer nota) {
	        Optional<List<Assistence>> assistence = assistenceRepository.findByNota(nota);
	        if (assistence.isPresent()) {
	            return assistence;
	        }
	        return null;
	    }

	
	@PostMapping("/add")
	public Assistence postAssis(@RequestBody Assistence assistence) {
		assistenceRepository.save(assistence);
		return assistence;
	}
	
	
	@PutMapping("/{id}")
    public Assistence putAssistence(@PathVariable Integer id, @RequestBody Assistence assistence) {
        Optional<Assistence> asisCurrent = assistenceRepository.findById(id);
        if (asisCurrent.isPresent()) {
            Assistence asisReturn = asisCurrent.get();
            asisReturn.setNota(assistence.getNota()); 
            assistenceRepository.save(asisReturn);
            return asisReturn;
        }
        return null;
    }
	
	  @DeleteMapping("/{id}")
	    public Assistence deleteAssistence(@PathVariable Integer id) {
	        Optional<Assistence> assistence = assistenceRepository.findById(id);
	        if (assistence.isPresent()) {
	            assistenceRepository.deleteById(id);
	            return assistence.get();
	        }
	        return null;
	    }
		
	

	
	
}
