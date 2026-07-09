package in.coderArmy.controller;

import in.coderArmy.entity.Student;
import in.coderArmy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentSetvice;

    @Autowired
    public StudentController(StudentService studentSetvice) {
        this.studentSetvice = studentSetvice;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentSetvice.saveStudent(studentReq);
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentSetvice.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentResp = studentSetvice.getAllStudents();
        if(studentResp.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentResp);
    }

}
