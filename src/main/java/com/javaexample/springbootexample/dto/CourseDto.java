package com.javaexample.springbootexample.dto;

import com.javaexample.springbootexample.data.Course;
import com.javaexample.springbootexample.data.Topic;


public class CourseDto {
    private Long id;
    private String name;
    private String description;

    private Topic topic;

    public CourseDto() {
    }

    public CourseDto(Course course) {
        id = course.getId();
        name = course.getName();
        description = course.getDescription();
        topic = course.getTopic();
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
