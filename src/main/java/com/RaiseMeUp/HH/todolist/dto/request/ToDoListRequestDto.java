package com.RaiseMeUp.HH.todolist.dto.request;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
public class ToDoListRequestDto {

  private Long id;
  private String content;
  private Boolean isCompleted;
  private LocalDateTime createdDateTime;

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Boolean getCompleted() {
    return isCompleted;
  }

  public LocalDateTime getCreatedDateTime() {
    return createdDateTime;
  }
}
//Request validation
//spring validation 체크
//헤이티오스