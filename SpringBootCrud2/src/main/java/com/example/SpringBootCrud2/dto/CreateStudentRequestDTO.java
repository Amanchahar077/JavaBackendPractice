package com.example.SpringBootCrud2.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

public class CreateStudentRequestDTO {

    @NotBlank(message = "Name cannot be left blank")
    @Size(min = 1, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Rollno cannot be null")
    @Positive(message = "Rollno cannot be negative")
    private int rollno;

    @NotBlank(message = "Email cannot be left blank")
    @Email(message = "Not a valid format of email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
