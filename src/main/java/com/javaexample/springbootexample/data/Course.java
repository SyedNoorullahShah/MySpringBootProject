package com.javaexample.springbootexample.data;

import com.javaexample.springbootexample.dto.CourseDto;
import com.javaexample.springbootexample.dto.payload.CourseRequestDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Topic topic;

    public Course() {
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(CourseRequestDto courseDto) {
        this.name = courseDto.getName();
        this.description = courseDto.getDescription();
        this.topic = new Topic("", "");
        topic.setId(courseDto.getTopicId());
    }

    public void setTopic(Long topicId) {
        this.topic = new Topic("", "");
        topic.setId(topicId);
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


    public void updateCourseDetails(CourseRequestDto updatedCourseDto) {
        setName(updatedCourseDto.getName());
        setDescription(updatedCourseDto.getDescription());
        setTopic(updatedCourseDto.getTopicId());
    }
}
