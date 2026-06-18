package com.telusko.course_management_app.service;

import java.util.List;
import com.telusko.course_management_app.entity.Course;

public interface ICourseService {

    void registerCourse(Course course);

    List<Course> getAllCourses();

    void deleteCourse(Integer id);
}