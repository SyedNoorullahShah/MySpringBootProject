package com.javaexample.springbootexample.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    //test comment master
    @RequestMapping(value = "/Courses", method = RequestMethod.GET)
    public List<Course> sendCourses() {
        return coursesService.getCourses();
    }

    @RequestMapping(value = "/Courses/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable String id) {
        return coursesService.getCourseById(id);
    }

    @RequestMapping(value = "/Courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course newCourse) {
        coursesService.addCourse(newCourse);
    }

    @RequestMapping(value = "/Courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course updatedCourse, @PathVariable String id) {
        coursesService.updateCourse(updatedCourse, id);
    }

    @RequestMapping(value = "/Courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
    }
}
