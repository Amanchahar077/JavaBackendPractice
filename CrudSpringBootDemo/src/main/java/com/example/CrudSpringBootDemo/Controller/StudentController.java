package com.example.CrudSpringBootDemo.Controller;

import com.example.CrudSpringBootDemo.Entity.Student;
import com.example.CrudSpringBootDemo.Service.StudentService;
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

    //create student --> POST --> api/students/create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                //.status(201)
                .status(HttpStatus.CREATED)//alternate
                .body(createdStudent);
    }



    //read student --> GET --> api/students/{id}
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentResp);
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //read all --> GET --> api/students

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentresp = studentService.getAllStudent();
        if(studentresp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentresp);
    }

    //update student --> PUT --> api/students/{id}

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student studentReq){
        Student studentResp = studentService.updateStudent(id,studentReq);
        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //delete student --> DELETE --> api/students/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.status(HttpStatus.OK).body(deletedStudent);
        //alternate
        return ResponseEntity.ok("Record Deleted");
    }

}
