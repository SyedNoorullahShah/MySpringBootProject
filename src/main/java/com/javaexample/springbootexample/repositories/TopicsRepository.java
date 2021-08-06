package com.javaexample.springbootexample.repositories;

import com.javaexample.springbootexample.data.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topic, Long> {
}
