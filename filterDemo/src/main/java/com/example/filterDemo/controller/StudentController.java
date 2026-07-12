package com.example.filterDemo.controller;

import com.example.filterDemo.dto.StudentDTO;
import com.example.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(StudentDTO req){
        studentService.createStudent(req);
        return ResponseEntity.ok("Done");
    }
}
