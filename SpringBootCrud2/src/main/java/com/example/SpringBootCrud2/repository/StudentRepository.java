package com.example.SpringBootCrud2.repository;

import com.example.SpringBootCrud2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Boolean existsByEmail(String emailId);

    List<Student> findByDeletedIsFalse();
}
