package com.RaiseMeUp.HH.todolist.dto.response;

import lombok.Builder;

@Builder
public class ToDoListResponseDto{

  private Long id;
  private String content;
  private Boolean isCompleted;


  @Override
  public String toString(){
    return "ToDoList  [id=" + id +
        ", content=" + content +
        ", isComplete=" + isCompleted + "]";
  }
}
