package com.RaiseMeUp.HH.todolist.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListRequest {

  private String content;
  private Boolean completed;
}
