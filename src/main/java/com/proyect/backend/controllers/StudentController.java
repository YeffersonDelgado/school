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

import com.proyect.backend.entities.Student;
import com.proyect.backend.repositories.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
    StudentRepository studentRepository;

    @GetMapping("/{id}")
    public Optional<Student> findStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student;
        }
        return null;
    }
    
    @GetMapping("/nombre={nombre}")
    public Optional<List<Student>> findStudentByNombre(@PathVariable String nombre) {
        Optional<List<Student>> student = studentRepository.findByNombre(nombre);
        if (student.isPresent()) {
            return student;
        }
        return null;
    }

    @PostMapping("/add")
    public Student postStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student putStudent(@PathVariable Integer id, @RequestBody Student student) {
        Optional<Student> studentCurrent = studentRepository.findById(id);
        if (studentCurrent.isPresent()) {
            Student studentReturn = studentCurrent.get();
            studentReturn.setNombre(student.getNombre());
            studentReturn.setApellido(student.getApellido());
            studentReturn.setDireccion(student.getDireccion());
            studentReturn.setTelefono(student.getTelefono());
            studentReturn.setEdad(student.getEdad());
            studentRepository.save(studentReturn);
            return studentReturn;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return student.get();
        }
        return null;
    }
	
}
