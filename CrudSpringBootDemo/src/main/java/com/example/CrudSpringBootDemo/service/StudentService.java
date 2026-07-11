package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.exception.DuplicateResourceException;
import com.example.CrudSpringBootDemo.exception.ResourceNotFoundException;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import com.example.CrudSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.CrudSpringBootDemo.dto.CreateStudentResponseDTO;
import com.example.CrudSpringBootDemo.dto.UpdateStudentRequestDTO;
import com.example.CrudSpringBootDemo.dto.UpdateStudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    //business logic

    //Create
    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReq){
        //Dto to Student
        Student student = mapDtoToStudent(studentReq);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email "+student.getEmail()+" already exists!!");
        }

        //Student saved to DB through Repository
        Student studentResp = studentRepository.save(student);
        //Student to Dto converted then retured to controller
        return mapStudentToDto(studentResp);
    }

    //Read
    public CreateStudentResponseDTO getStudent(Long id){

        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+id+"not found!!"));
                return mapStudentToDto(studentResp);


//        *****Alternative*****
//        Optional<Student> studentResp = studentRepository.findByIdAndIsDeletedIsFalse(id);
//        if(!studentResp.isPresent()){
//            return null;
//        }
//        CreateStudentResponseDTO resp = mapStudentToDto(studentResp.get());
//        return resp;
    }

    //ReadAll
    public List<CreateStudentResponseDTO> getAllStudent(){
        List<Student> studentRespe = studentRepository.findByDeletedIsFalse();
        List<CreateStudentResponseDTO> resp = new ArrayList<>();
        for(CreateStudentResponseDTO a: resp){
            resp.add(a);
        }
        return resp;
    }

    //Update
    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO studentReq){
        //check if stu exist
        Student existingStudent = studentRepository
                .findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
        //update student
        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollno(studentReq.getRollno());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        //set updated student in DB
        Student studentResp = studentRepository.save(existingStudent);
        //Convert Student to DTO and return
        return mapUpdateStudentToDTO(studentResp);
    }

    public void deleteStudent(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+id+" not found"));

        studentRepository.delete(studentToBeDeleted);
    }

    public void softDelete(Long id){
        Student studentToBeDeleted = studentRepository
                .findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" not found"));
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapDtoToStudent(CreateStudentRequestDTO studentReq){
        Student student = new Student();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setRollno(studentReq.getRollno());
        student.setEmail(studentReq.getEmail());
        student.setSubject(studentReq.getSubject());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapStudentToDto(Student student){
        CreateStudentResponseDTO responseDto = new CreateStudentResponseDTO();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollno(student.getRollno());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student Saved Successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    private UpdateStudentResponseDTO mapUpdateStudentToDTO(Student student){
        UpdateStudentResponseDTO responseDto = new UpdateStudentResponseDTO();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollno(student.getRollno());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student Saved Successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    public Boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }

}
