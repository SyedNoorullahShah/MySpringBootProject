package com.javaexample.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepo repo;

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        repo.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(String id) {
        return repo.findById(id).get();
    }

    public void addTopic(Topic newTopic) {
        repo.save(newTopic);
    }

    public void updateTopic(Topic updatedTopic) {
        repo.save(updatedTopic);
    }

    public void deleteTopic(String id) {
        repo.deleteById(id);
    }
}
