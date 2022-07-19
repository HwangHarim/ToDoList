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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

  @Column(columnDefinition = "boolean default false")
  private Boolean isCompleted;

  @Column(name="crated_date", columnDefinition = "DATE")
  @CreatedDate
  private LocalDateTime createdDateTime;

  @Column(name="modified_date", columnDefinition = "DATE")
  @LastModifiedDate
  private LocalDateTime modifiedDate;

  public void update(String content){
    this.content = content;
  }
}