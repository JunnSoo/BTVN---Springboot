package com.springbootapi.btvnbuoi34.controller;

import com.springbootapi.btvnbuoi34.entity.Student;
import com.springbootapi.btvnbuoi34.repository.StudentRepository;
import com.springbootapi.btvnbuoi34.request.StudentRequest;
import com.springbootapi.btvnbuoi34.respone.BaseRespone;
import com.springbootapi.btvnbuoi34.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> danhSachHocSinh(){
        BaseRespone baseRespone = new BaseRespone();
        baseRespone.setCode(HttpStatus.OK.value());
        baseRespone.setMessage("OK");
        baseRespone.setData(studentService.findAll());
        return ResponseEntity.ok(baseRespone);
    }

    @PostMapping
    public ResponseEntity<?> themHocSinh(@RequestBody StudentRequest studentRequest){
        try {
            Student saved = studentService.luuHocSinh(studentRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)  // 201
                    .body(saved);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Lỗi khi lưu học sinh: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/courses/{courseId}")
    public ResponseEntity<?> themHocSinh(@PathVariable int id, @PathVariable int courseId){
        studentService.registerCourse(id, courseId);
        return ResponseEntity.ok("student "+ id + " register successfully ");
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getStudentCourses(@PathVariable int id){
        return ResponseEntity.ok(studentService.findCourseByStudentId(id));
    }
}
