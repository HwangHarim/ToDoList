package com.RaiseMeUp.HH.todolist.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class ToDoList {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "todolist_id")
  private Long id;

  private String content;

  @Column
  private Boolean isComplete;

  @Column
  private LocalDateTime createdDateTime;

  @Builder
  public ToDoList(Long id, String content, Boolean isComplete, LocalDateTime createdDateTime) {
    this.id = id;
    this.content = content;
    this.isComplete = isComplete;
    this.createdDateTime = createdDateTime;
  }
}
