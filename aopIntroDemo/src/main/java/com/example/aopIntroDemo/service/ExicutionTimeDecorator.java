package com.example.aopIntroDemo.service;

import com.example.aopIntroDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExicutionTimeDecorator implements StudentService {

    private LoggingDecorator loggingDecorator;

    public ExicutionTimeDecorator(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }


    @Override
    public void createStudent(Student student) {
        long start = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long end = System.currentTimeMillis();

        System.out.println("Exicution time -> " + (end - start) + " milliseconds");
    }
}
