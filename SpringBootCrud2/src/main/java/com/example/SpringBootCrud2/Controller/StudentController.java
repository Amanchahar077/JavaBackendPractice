package com.example.SpringBootCrud2.Controller;

import com.example.SpringBootCrud2.Entity.Student;
import com.example.SpringBootCrud2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create POST --> /create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Entered StuController");
        Student studentResp = studentService.createStudent(student);
        System.out.println("Exited StuController");
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResp);
    }

    //read GET --> /getall
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = studentService.getAllStudent();
        if(student.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    //read GET ==> /get/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //update PUT --> /update/{id}
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentReq){
        Student studentResp = studentService.updateStudent(id,studentReq);
        if(studentResp==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //DELETE --> /delete/{id}
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }


}
