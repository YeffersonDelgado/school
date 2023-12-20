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

import com.proyect.backend.entities.Course;
import com.proyect.backend.repositories.CourseRepository;


@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

	@Autowired
    CourseRepository courseRepository;

    @GetMapping("/{id}")
    public Optional<Course> findCourseById(@PathVariable Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course;
        }
        return null;
    }
    
    @GetMapping("/nombre={nombre}")
    public Optional<List<Course>> findCourseByNombre(@PathVariable String nombre) {
        Optional<List<Course>> course = courseRepository.findByNombre(nombre);
        if (course.isPresent()) {
            return course;
        }
        return null;
    }

    @PostMapping("/add")
    public Course postCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return course;
    }

    @PutMapping("/{id}")
    public Course putCourse(@PathVariable Integer id, @RequestBody Course course) {
        Optional<Course> courseCurrent = courseRepository.findById(id);
        if (courseCurrent.isPresent()) {
            Course courseReturn = courseCurrent.get();
            courseReturn.setNombre(course.getNombre());
            courseReturn.setFechaInicio(course.getFechaInicio());
            courseReturn.setFechaFin(course.getFechaFin());

            courseRepository.save(courseReturn);
            return courseReturn;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
        	courseRepository.deleteById(id);
            return course.get();
        }
        return null;
    }
	
}
