package com.example.SpringBootCrud2.controller;

import com.example.SpringBootCrud2.dto.CreateStudentRequestDTO;
import com.example.SpringBootCrud2.dto.CreateStudentResponseDTO;
import com.example.SpringBootCrud2.entity.Student;
import com.example.SpringBootCrud2.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<CreateStudentResponseDTO> CreateStudent(@Valid @RequestBody CreateStudentRequestDTO req){
        CreateStudentResponseDTO res = studentService.createStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    //Read
    @GetMapping("/read/{id}")
    public ResponseEntity<CreateStudentResponseDTO> readStudent(@PathVariable Long id){
        CreateStudentResponseDTO res = studentService.readStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //ReadAll
    @GetMapping("/readall")
    public ResponseEntity<List<CreateStudentResponseDTO>> realAllStudents(){
        List<CreateStudentResponseDTO> resp = studentService.readAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    //Update


    //Delete


    //SoftDelete



}
