package com.telusko.course_management_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.course_management_app.entity.Course;
import com.telusko.course_management_app.service.ICourseService;

@Controller
public class CourseController
{
    private ICourseService service;

    @Autowired
    public void setService(ICourseService service)
    {
        this.service = service;
    }

    @GetMapping("/courselist")
    public String getAllCourses(Model model)
    {
        List<Course> courses = service.getAllCourses();

        model.addAttribute("courses", courses);

        return "courselist";
    }

    @GetMapping("/showCourseForm")
    public String showForm(@ModelAttribute("course") Course course)
    {
        return "courseform";
    }

    @GetMapping("/updateCourseForm")
    public String updateForm(@RequestParam("id") Integer id,
                             Model model)
    {
        Course course = service.getCourseById(id);

        model.addAttribute("course", course);

        return "courseform";
    }

    @PostMapping("/registerCourse")
    public String registerCourse(@ModelAttribute("course") Course course)
    {
        service.registerCourse(course);

        return "redirect:/courselist";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourseById(@RequestParam("id") Integer id)
    {
        service.deleteCourse(id);

        return "redirect:/courselist";
    }
}