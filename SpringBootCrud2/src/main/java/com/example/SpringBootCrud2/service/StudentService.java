package com.example.SpringBootCrud2.service;

import com.example.SpringBootCrud2.dto.CreateStudentRequestDTO;
import com.example.SpringBootCrud2.dto.CreateStudentResponseDTO;
import com.example.SpringBootCrud2.entity.Student;
import com.example.SpringBootCrud2.exceptions.DuplicateResourceException;
import com.example.SpringBootCrud2.exceptions.ResourceNotFoundException;
import com.example.SpringBootCrud2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Create
    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO req){
        Student student = mapDtoToStudent(req);
        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email "+student.getEmail()+" already exists");
        }
        Student resp = studentRepository.save(student);
        return mapStudentToDto(resp);
    }

    //Read
    public CreateStudentResponseDTO readStudent(Long id){
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id "+id+" not found"));
        CreateStudentResponseDTO res = mapStudentToDto(student);
        return res;
    }

    //ReadAll
    public List<CreateStudentResponseDTO> readAllStudents(){
        List<Student> students =studentRepository.findAll();
        List<CreateStudentResponseDTO> resp = new ArrayList<>();
        for(Student s:students){
            CreateStudentResponseDTO stu = mapStudentToDto(s);
            resp.add(stu);
        }
        return resp;
    }










    //Check Email Exists
    public Boolean emailExists(Student stu){
        return studentRepository.existsByEmail(stu.getEmail());
    }

    //DTOP to Student
    public Student mapDtoToStudent(CreateStudentRequestDTO req){
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail());
        student.setRollno(req.getRollno());
        student.setDeleted(false);
        return student;
    }

    //Student to DTO
    public CreateStudentResponseDTO mapStudentToDto(Student stu){
        CreateStudentResponseDTO resp = new CreateStudentResponseDTO();
        resp.setId(stu.getId());
        resp.setName(stu.getName());
        resp.setEmail(stu.getEmail());
        resp.setRollno(stu.getRollno());
        return resp;
    }

}
