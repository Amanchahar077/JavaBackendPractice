package com.example.SpringBootCrud2.Repository;

import com.example.SpringBootCrud2.Entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public Student setStudent(Student studentReq){
        System.out.println("Entered StuRepo");
        Student s1 = new Student();
        s1.getAge();
        s1.getEmail();
        s1.getId();
        s1.getName();
        s1.getRollno();
        s1.getSubject();
        System.out.println("Exited StuRepo");
        return s1;
    }

}
