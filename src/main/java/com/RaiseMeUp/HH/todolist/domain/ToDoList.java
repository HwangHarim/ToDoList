package com.RaiseMeUp.HH.todolist.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
  private LocalDateTime createdDateTime;

  @Override
  public String toString(){
    return "ToDoList  [id=" + id +
        ", content=" + content +
        ", isComplete=" + isCompleted + "]";
  }
}