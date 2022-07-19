package com.RaiseMeUp.HH.todolist.todolistconverter;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.dto.request.ToDoListRequestDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class ToDoListConverter {

  public ToDoList createToDo(Long id, String content, Boolean isCompleted,  LocalDateTime createDateTime) {
    return ToDoList.builder()
        .id(id)
        .content(content)
        .isCompleted(isCompleted)
        .createdDateTime(createDateTime)
        .build();
  }

  public ToDoList updateToDo(Long id, String content, Boolean isCompleted,  LocalDateTime createDateTime) {
    return ToDoList.builder()
        .id(id)
        .content(content)
        .isCompleted(isCompleted)
        .createdDateTime(createDateTime)
        .build();
  }

  public ToDoListRequestDto toToDoRequestDto(Long id, String content, Boolean isCompleted,  LocalDateTime createDateTime){
    return ToDoListRequestDto.builder()
        .id(id)
        .content(content)
        .isCompleted(isCompleted)
        .createdDateTime(createDateTime)
        .build();
  }
}