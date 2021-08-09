package com.javaexample.springbootexample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaexample.springbootexample.data.Topic;

public class TopicDto {
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;
  private String name;
  private String description;

  public TopicDto() {

  }

  public TopicDto(Topic topic) {
    this.id = topic.getId();
    this.name = topic.getName();
    this.description = topic.getDescription();
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

}
