package com.RaiseMeUp.HH.todolist.infrastructure;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}