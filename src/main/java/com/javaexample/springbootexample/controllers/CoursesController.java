package com.javaexample.springbootexample.controllers;

import com.javaexample.springbootexample.dto.CourseDto;
import com.javaexample.springbootexample.dto.payload.CourseRequestDto;
import com.javaexample.springbootexample.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("topics/{topicId}/courses")
    public List<CourseDto> getTopicCourses(@PathVariable Long topicId) {
        return coursesService.getCourses(topicId);
    }

    @GetMapping("topics/courses/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return coursesService.getCourseById(id);
    }

    @PostMapping("topics/courses")
    public CourseDto addCourse(@RequestBody CourseRequestDto newCourse) {
        return coursesService.addCourse(newCourse);
    }

    @PutMapping("topics/courses/{id}")
    public CourseDto updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto updatedCourse) {
        return coursesService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("topics/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(id);
    }
}
