package com.example.CrudSpringBootDemo.controller;

import com.example.CrudSpringBootDemo.service.StudentService;
import com.example.CrudSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.CrudSpringBootDemo.dto.CreateStudentResponseDTO;
import com.example.CrudSpringBootDemo.dto.UpdateStudentRequestDTO;
import com.example.CrudSpringBootDemo.dto.UpdateStudentResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //Validations = dependency -> SpringBoot-startar-validations

    //create student --> POST --> api/students/create
    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO student){
        CreateStudentResponseDTO createdStudent = studentService.createStudent(student);
        return ResponseEntity
                //.status(201) //alternate
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }



    //read student --> GET --> api/students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){//Can use @Pathvariable also
        CreateStudentResponseDTO studentResp = studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //read all --> GET --> api/students

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO> studentresp = studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(studentresp);
    }

    //update student --> PUT --> api/students/{id}

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDTO> updateStudent(@PathVariable Long id,
                                                                  @RequestBody UpdateStudentRequestDTO studentReq){
        UpdateStudentResponseDTO studentResp = studentService.updateStudent(id,studentReq);
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //delete student --> DELETE --> api/students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){//Can use @Pathvariable also
        studentService.deleteStudent(id);
        //alternate
        //return ResponseEntity.status(HttpStatus.OK).body(deletedStudent);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //softDelete student --> PATCH --> api/students/softdelete/{id}
    @PatchMapping("/softdelete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        studentService.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
