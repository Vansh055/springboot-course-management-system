package com.telusko.course_management_app.controller;

import com.telusko.course_management_app.entity.Course;
import com.telusko.course_management_app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        List<Course> courseList = courseService.getAllCourses();

        model.addAttribute("courseList", courseList);

        return "index";
    }
}
