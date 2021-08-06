package com.javaexample.springbootexample.dto.payload;

public class CourseRequestDto {
  private String name;
  private String description;
  private Long topicId;

  CourseRequestDto() {

  }

  CourseRequestDto(String name, String description, Long topicId) {
    this.name = name;
    this.description = description;
    this.topicId = topicId;
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

  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }

}
