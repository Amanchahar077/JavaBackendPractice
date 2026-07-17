package com.example.aopIntroDemo.repository;

import com.example.aopIntroDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(Student student){
        System.out.println("Student is Saved!!");
    }
}
