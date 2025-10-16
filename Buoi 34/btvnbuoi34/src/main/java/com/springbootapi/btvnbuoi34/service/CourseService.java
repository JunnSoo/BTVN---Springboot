package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.Course;
import com.springbootapi.btvnbuoi34.request.CourseRequest;

public interface CourseService {
    Course addCourse(CourseRequest courseRequest);
}
