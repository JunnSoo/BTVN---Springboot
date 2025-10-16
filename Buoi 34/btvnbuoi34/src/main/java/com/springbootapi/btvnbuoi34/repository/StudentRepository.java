package com.springbootapi.btvnbuoi34.repository;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.entity.Student;
import com.springbootapi.btvnbuoi34.request.StudentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAll();
    @Query(value = "SELECT s.courses FROM Student s WHERE s.id = :studentId")
    List<Course> findCourseByStudentId(@Param("studentId") Integer studentId);
}
