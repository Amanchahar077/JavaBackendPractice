package com.example.aopIntroDemo.service;

import com.example.aopIntroDemo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService{

    StudentServiceImpl studentServiceImpl;

    @Autowired
    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        //Loging related logic
        LoggingServiceUtil.logStart(
                "StudentServiceImpl","createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logFinish(
                "StudentServiceImpl","createStudent");
    }
}
