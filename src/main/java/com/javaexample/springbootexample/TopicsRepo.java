package com.javaexample.springbootexample;

import org.springframework.data.repository.CrudRepository;

public interface TopicsRepo extends CrudRepository<Topic, String> {
}
