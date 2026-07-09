package in.coderArmy.repository;

import in.coderArmy.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<Long, Student> studentDB;

    public StudentRepository() {
        studentDB = new HashMap<>();
    }

    public Student saveStudent(Student studentReq){
        studentDB.put(studentReq.getId(),studentReq);
        return studentReq;
    }

    public Student getStudent(Long id){
        return studentDB.get(id);
    }

    public List<Student> getAllStudent(){
        return new ArrayList<>(studentDB.values());
    }

}
