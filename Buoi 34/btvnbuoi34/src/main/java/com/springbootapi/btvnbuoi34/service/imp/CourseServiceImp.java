package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.repository.CourseRepository;
import com.springbootapi.btvnbuoi34.request.CourseRequest;
import com.springbootapi.btvnbuoi34.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp  implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(CourseRequest  courseRequest) {
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        return courseRepository.save(course);
    }
}
