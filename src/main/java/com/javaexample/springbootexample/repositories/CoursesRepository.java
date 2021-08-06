package com.javaexample.springbootexample.repositories;

import com.javaexample.springbootexample.data.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Long> {
    List<Course> findByTopicId(Long id);
}
