package com.javaexample.springbootexample.services;

import com.javaexample.springbootexample.data.Course;
import com.javaexample.springbootexample.data.Topic;
import com.javaexample.springbootexample.dto.CourseDto;
import com.javaexample.springbootexample.dto.TopicDto;
import com.javaexample.springbootexample.dto.payload.CourseRequestDto;
import com.javaexample.springbootexample.repositories.CoursesRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository repo;

    public List<CourseDto> getCourses(Long topicId) {
        return repo.findByTopicId(topicId).stream()
            .map(CourseDto::new)
            .collect(Collectors.toList());
    }

    public CourseDto getCourseById(Long id) {
        Optional<Course> course = repo.findById(id);
        return course.isPresent() ? new CourseDto(course.get()) : null;
    }

    public CourseDto addCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course(courseRequestDto);
        return new CourseDto(repo.save(course));
    }

    public CourseDto updateCourse(Long id, CourseRequestDto updatedCourseDto) {
        Course updatedCourse = new Course(updatedCourseDto);
        updatedCourse.setId(id);
        return new CourseDto(repo.save(updatedCourse));
    }

    public void deleteCourse(Long id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
        }
        else{
            throw new ServiceException("Course for this id doesn't exist");
        }
    }
}
