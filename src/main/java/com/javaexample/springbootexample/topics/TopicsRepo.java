package com.javaexample.springbootexample.topics;

import org.springframework.data.repository.CrudRepository;

public interface TopicsRepo extends CrudRepository<Topic, String> {
}
