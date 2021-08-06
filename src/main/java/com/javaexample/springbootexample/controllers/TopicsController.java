package com.javaexample.springbootexample.controllers;

import com.javaexample.springbootexample.data.Topic;
import com.javaexample.springbootexample.dto.TopicDto;
import com.javaexample.springbootexample.services.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topics")
public class TopicsController {
    @Autowired
    private TopicsService topicsService;

    @GetMapping
    public List<TopicDto> getTopics() {
        return topicsService.getTopics();
    }

    @GetMapping("/{id}")
    public TopicDto getTopicById(@PathVariable Long id) {
        return topicsService.getTopicById(id);
    }

    @PostMapping
    public TopicDto addTopic(@RequestBody TopicDto newTopic) {
        return topicsService.addTopic(newTopic);
    }

    @PutMapping("/{id}")
    public TopicDto updateTopic(@PathVariable Long id, @RequestBody TopicDto updatedTopic) {
        return topicsService.updateTopic(id, updatedTopic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicsService.deleteTopic(id);
    }
}
