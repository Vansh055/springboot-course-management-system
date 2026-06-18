package com.telusko.course_management_app.repository;

import com.telusko.course_management_app.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}

