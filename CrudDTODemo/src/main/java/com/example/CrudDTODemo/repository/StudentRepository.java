package com.example.CrudDTODemo.repository;

import com.example.CrudDTODemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
