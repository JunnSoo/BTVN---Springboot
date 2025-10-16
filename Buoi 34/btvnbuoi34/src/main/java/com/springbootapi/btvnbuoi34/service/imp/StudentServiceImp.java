package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.entity.Student;
import com.springbootapi.btvnbuoi34.repository.CourseRepository;
import com.springbootapi.btvnbuoi34.repository.StudentRepository;
import com.springbootapi.btvnbuoi34.request.StudentRequest;
import com.springbootapi.btvnbuoi34.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student luuHocSinh(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public void registerCourse(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);
    }

    @Override
    public List<Course> findCourseByStudentId(int studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return studentRepository.findCourseByStudentId(studentId);
        }else {
            throw new RuntimeException("student not found");
        }
    }
}
