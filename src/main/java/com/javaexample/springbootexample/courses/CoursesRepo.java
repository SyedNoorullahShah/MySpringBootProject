package com.javaexample.springbootexample.courses;

import org.springframework.data.repository.CrudRepository;

public interface CoursesRepo extends CrudRepository<Course, String> {
}
