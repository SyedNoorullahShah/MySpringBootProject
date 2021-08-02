package com.javaexample.springbootexample.courses;

import com.javaexample.springbootexample.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    //test comment master
    @RequestMapping(value = "topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getTopicCourses(@PathVariable String topicId) {
        return coursesService.getCourses(topicId);
    }

    @RequestMapping(value = "topics/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable String id) {
        return coursesService.getCourseById(id);
    }

    @RequestMapping(value = "topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course newCourse, @PathVariable String topicId) {
        newCourse.setTopic(new Topic(topicId, "", ""));
        coursesService.addCourse(newCourse);
    }

    @RequestMapping(value = "topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course updatedCourse, @PathVariable String topicId) {
        updatedCourse.setTopic(new Topic(topicId, "", ""));
        coursesService.updateCourse(updatedCourse);
    }

    @RequestMapping(value = "topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
    }
}
