package com.javaexample.springbootexample.services;

import com.javaexample.springbootexample.data.Topic;
import com.javaexample.springbootexample.dto.TopicDto;
import com.javaexample.springbootexample.repositories.TopicsRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepository topicsRepository;

    public List<TopicDto> getTopics() {
        List<TopicDto> topics = new ArrayList<>();
        topicsRepository.findAll()
                .forEach(topic -> topics.add(new TopicDto(topic)));

        return topics;
    }

    public TopicDto getTopicById(Long id) {
        Optional<Topic> topic = topicsRepository.findById(id);
        return topic.isPresent() ? new TopicDto(topic.get()) : null;
    }

    public TopicDto addTopic(TopicDto newTopic) {
        Topic addedTopic = topicsRepository.save(new Topic(newTopic));
        return new TopicDto(addedTopic);
    }

    public TopicDto updateTopic(Long id, TopicDto updatedTopicDto) {
        Optional<Topic> topic = topicsRepository.findById(id);
        if (topic.isPresent()) {
            topic.get().updateTopicDetails(updatedTopicDto);
            return new TopicDto(topicsRepository.save(topic.get()));
        } else return null;

    }

    public void deleteTopic(Long id) {
        if (topicsRepository.findById(id).isPresent()) {
            topicsRepository.deleteById(id);
        } else {
            throw new ServiceException("Topic for this id doesn't exist");
        }
    }
}
