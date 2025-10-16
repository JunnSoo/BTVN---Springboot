package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.entity.Student;
import com.springbootapi.btvnbuoi34.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Student luuHocSinh(StudentRequest studentRequest);
    void registerCourse(int studentId, int courseId);
    List<Course> findCourseByStudentId(int studentId);
}
