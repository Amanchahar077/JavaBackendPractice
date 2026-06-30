package com.example.SpringBootCrud2.Service;

import com.example.SpringBootCrud2.Entity.Student;
import com.example.SpringBootCrud2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student studentLigic(Student studentReq){
        System.out.println("Entered StuService");
        Student studentResp = studentRepository.setStudent(studentReq);
        System.out.println("Exited StuService");
        return studentResp;
    }
}
