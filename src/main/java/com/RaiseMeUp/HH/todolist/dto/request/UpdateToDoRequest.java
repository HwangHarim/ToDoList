package com.RaiseMeUp.HH.todolist.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UpdateToDoRequest {
  private Long id;
  private String content;
  private LocalDateTime createDataTime = LocalDateTime.now();

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
