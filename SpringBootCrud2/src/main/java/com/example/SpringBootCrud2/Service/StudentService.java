package com.example.SpringBootCrud2.Service;

import com.example.SpringBootCrud2.Entity.Student;
import com.example.SpringBootCrud2.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public List<Student> getAllStudent(){
        List<Student> studentResp = studentRepository.findAll();
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isEmpty()){
            return null;
        }
        return studentResp.get();
    }

    public Student updateStudent(Long id,Student studentReq){

        Optional<Student> stu = studentRepository.findById(id);

        if(stu.isEmpty()){
            return null;
        }

        Student student = stu.get();

        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setRollno(studentReq.getRollno());
        student.setSubject(studentReq.getSubject());

        return studentRepository.save(student);
    }

    public Boolean deleteStudent(Long id){
        Optional<Student> stu = studentRepository.findById(id);
        if(stu.isEmpty()){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

}
