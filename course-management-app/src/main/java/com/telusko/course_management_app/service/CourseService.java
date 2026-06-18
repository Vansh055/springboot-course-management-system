package com.telusko.course_management_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.course_management_app.entity.Course;
import com.telusko.course_management_app.repository.CourseRepository;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository repo;

    @Override
    public void registerCourse(Course course) {
        repo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) repo.findAll();
    }

    @Override
    public void deleteCourse(Integer id) {
        repo.deleteById(id);
    }
}