package com.javaexample.springbootexample.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepo repo;

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        repo.findAll()
                .forEach(courses::add);
        return courses;
    }

    public Course getCourseById(String id) {
        return repo.findById(id).get();
    }

    public void addCourse(Course newCourse) {
        repo.save(newCourse);
    }

    public void updateCourse(Course updatedCourse, String id) {
        repo.save(updatedCourse);
    }

    public void deleteCourse(String id) {
        repo.deleteById(id);
    }
}
