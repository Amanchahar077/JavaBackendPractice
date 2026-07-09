package in.coderArmy.service;

import in.coderArmy.entity.Student;
import in.coderArmy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student saveStudent(Student studentReq){
        return studentRepo.saveStudent(studentReq);
    }

    public Student getStudent(Long id){
        return studentRepo.getStudent(id);
    }

    public List<Student> getAllStudents(){
        return studentRepo.getAllStudent();
    }
}
