package com.springbootapi.btvn32.controller;

import com.springbootapi.btvn32.entity.Product;
import com.springbootapi.btvn32.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable int id){
        Student student = new Student();
        student.setId(id);
        student.setName("test");
        return  ResponseEntity.ok(student);
    }
}
