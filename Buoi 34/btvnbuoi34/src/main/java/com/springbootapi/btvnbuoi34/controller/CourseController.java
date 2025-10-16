package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.request.CourseRequest;
import com.springbootapi.btvnbuoi34.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest  courseRequest) {
        try {
            courseService.addCourse(courseRequest);
            return ResponseEntity.ok(courseRequest);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
