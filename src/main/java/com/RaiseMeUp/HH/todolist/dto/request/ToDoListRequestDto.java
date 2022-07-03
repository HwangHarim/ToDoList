package com.RaiseMeUp.HH.todolist.dto.request;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class ToDoListRequestDto {

  private Long id;
  private String content;
  private Boolean isCompleted;
  private LocalDateTime createdDateTime;

  public static ToDoList toEntity(ToDoListRequestDto toDoListRequestDto) {
    return ToDoList.builder()
        .id(toDoListRequestDto.id)
        .content(toDoListRequestDto.content)
        .isCompleted(toDoListRequestDto.isCompleted)
        .createdDateTime(toDoListRequestDto.createdDateTime)
        .build();
  }
}
