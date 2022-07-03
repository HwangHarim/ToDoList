package com.RaiseMeUp.HH.todolist.todolistconverter;

import com.RaiseMeUp.HH.todolist.dto.request.ToDoListRequestDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class ToDoListConverter {

  public ToDoListRequestDto toDoListRequestDto(Long id, String content, LocalDateTime createDateTime, Boolean isCompleted){
    return ToDoListRequestDto.builder()
        .id(id)
        .content(content)
        .createdDateTime(createDateTime)
        .isCompleted(isCompleted)
        .build();
  }
}
