package com.javaexample.springbootexample.services;

import com.javaexample.springbootexample.data.Topic;
import com.javaexample.springbootexample.dto.TopicDto;
import com.javaexample.springbootexample.repositories.TopicsRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepository repo;

    public List<TopicDto> getTopics() {
        List<TopicDto> topics = new ArrayList<>();
        repo.findAll()
                .forEach(topic -> topics.add(new TopicDto(topic)));

        return topics;
    }

    public TopicDto getTopicById(Long id) {
        Optional<Topic> topic = repo.findById(id);
        return topic.isPresent() ? new TopicDto(topic.get()) : null;
    }

    public TopicDto addTopic(TopicDto newTopic) {
        Topic addedTopic = repo.save(new Topic(newTopic));
        newTopic = new TopicDto(addedTopic);
        return newTopic;
    }

    public TopicDto updateTopic(Long id, TopicDto updatedTopicDto) {
        Topic updatedTopic = new Topic(updatedTopicDto);
        updatedTopic.setId(id);
        repo.save(updatedTopic);
        updatedTopicDto = new TopicDto(updatedTopic);
        return updatedTopicDto;
    }

    public void deleteTopic(Long id) {
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
        }
        else{
          throw new ServiceException("Topic for this id doesn't exist");
        }
    }
}
