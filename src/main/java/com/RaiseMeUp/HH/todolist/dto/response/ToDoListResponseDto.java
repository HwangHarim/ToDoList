package com.RaiseMeUp.HH.todolist.dto.response;

import lombok.Builder;

@Builder
public class ToDoListResponseDto{

  private Long id;
  private String content;
  private Boolean isCompleted;



}