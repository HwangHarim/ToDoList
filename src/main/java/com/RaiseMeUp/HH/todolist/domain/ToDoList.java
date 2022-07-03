package com.RaiseMeUp.HH.todolist.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ToDoList {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "todolist_id")
  private Long id;

  @NonNull
  private String content;

  @Column
  private Boolean isCompleted;

  @Column
  private LocalDateTime createdDateTime;
}
