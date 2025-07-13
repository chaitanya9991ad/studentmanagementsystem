package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.com.example.studentmanagementsystem.api.Student;
import org.springframework.data.repository.CrudRepository;

public interface studentRepository extends CrudRepository<Student, Integer> {
}
