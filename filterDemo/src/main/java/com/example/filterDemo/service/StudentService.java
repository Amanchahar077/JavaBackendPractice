package com.example.filterDemo.service;

import com.example.filterDemo.dto.StudentDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentDTO createStudent(StudentDTO req){
        System.out.println(req.getId());
        System.out.println(req.getName());
        System.out.println(req.getEmail());
        return req;
    }
}
