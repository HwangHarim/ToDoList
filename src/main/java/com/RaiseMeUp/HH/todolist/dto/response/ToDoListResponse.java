package com.RaiseMeUp.HH.todolist.dto.response;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListResponse {

  private Long id;
  private String content;
  private Boolean isCompleted;

  public ToDoListResponse(ToDoList toDoList) {
    this.id = toDoList.getId();
    this.content = toDoList.getContent();
    this.isCompleted = toDoList.getIsComplete();
  }

  @Override
  public String toString(){
    return "ToDoList  [id=" + id +
        ", content=" + content +
        ", isComplete=" + isCompleted + "]";
  }
}
