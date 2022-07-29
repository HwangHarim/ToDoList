package com.RaiseMeUp.HH.todolist.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToDoResponse {

  private Long id;
  private String content;
  private Boolean isCompleted;
  private LocalDateTime createDateTime;


  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Boolean getCompleted() {
    return isCompleted;
  }

  public LocalDateTime getCreateDateTime() {
    return createDateTime;
  }
}