package com.example.CrudSpringBootDemo.Service;

import com.example.CrudSpringBootDemo.Entity.Student;
import com.example.CrudSpringBootDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    //businerr logic

    public Student createStudent(Student studentReq){
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(!studentResp.isPresent()){
            return null;
        }
        return studentResp.get();
    }

    public List<Student> getAllStudent(){
        List<Student> studentRespe = studentRepository.findAll();
        return studentRespe;
    }

    public Student updateStudent(Long id,Student studentReq){
        //check if stu exist
        Optional<Student> existingStudent = studentRepository.findById(id);

        //if not return null
        if(existingStudent.isEmpty()){
            return null;
        }
        //make new student for updates
        Student studentToSave = existingStudent.get();
        //update student
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollno(studentReq.getRollno());
        studentToSave.setSubject(studentReq.getSubject());
        //set updated student in DB
        Student studentResp = studentRepository.save(studentToSave);
        //return updated student
        return studentResp;
    }

    public Boolean deleteStudent(Long id){
        Boolean isDeleted = studentRepository.existsById(id);
        if(!isDeleted){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

}
