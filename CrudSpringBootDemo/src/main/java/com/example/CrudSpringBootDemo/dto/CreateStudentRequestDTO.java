package com.example.CrudSpringBootDemo.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class CreateStudentRequestDTO {

    // Name

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    // Age
    @Min(value = 13, message = "Age must be at least 13")
    @Max(value = 100, message = "Age cannot be more than 100")
    private int age;
    // Email
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please enter a valid email address")
    private String email;
    // Roll Number
    @NotNull(message = "Roll no cannot be null")
    @Positive(message = "Roll number must be greater than 0")
    private int rollno;
    // Subject
    @NotBlank(message = "Subject cannot be blank")
    @Size(min = 2, max = 30, message = "Subject must be between 2 and 30 characters")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
