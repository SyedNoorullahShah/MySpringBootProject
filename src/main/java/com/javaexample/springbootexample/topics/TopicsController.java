package com.javaexample.springbootexample.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsController {
    @Autowired
    private TopicsService topicsService;
    //test comment master
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> sendTopics() {
        return topicsService.getTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopicById(@PathVariable String id) {
        return topicsService.getTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic newTopic) {
        topicsService.addTopic(newTopic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic updatedTopic, @PathVariable String id) {
        topicsService.updateTopic(updatedTopic, id);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {
        topicsService.deleteTopic(id);
    }
}
