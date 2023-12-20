package com.proyect.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_student;
    
	private String nombre;
	
	private String apellido;
	
	private String direccion;
	
	private Integer telefono;
	
	private Integer edad;
	
	
}
