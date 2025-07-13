package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.com.example.studentmanagementsystem.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.studentmanagementsystem.repository.studentRepository;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")  // Consistent base path
public class studentcontroller {

    @Autowired
    private studentRepository repository;

    @PostMapping("/addstudent")
    public Student createStudent(@RequestBody Student student) {
         return repository.save(student);
    }

    @GetMapping("/getbyid/{rollno}")
    public Optional<Student> getStudent(@PathVariable int rollno) {
        return repository.findById(rollno);
    }

    @GetMapping("/viewall")
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @PutMapping("/update/{rollno}")
    public Student updateStudent(@PathVariable int rollno, @RequestBody Student updated) {
        updated.setRollno(rollno);
        return repository.save(updated);
    }

    @DeleteMapping("/del/{rollno}")
    public void deleteStudent(@PathVariable int rollno) {
        repository.deleteById(rollno);
    }
}