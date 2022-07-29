package com.RaiseMeUp.HH.todolist.application;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.dto.request.CreateToDoRequest;
import com.RaiseMeUp.HH.todolist.dto.request.UpdateToDoRequest;
import com.RaiseMeUp.HH.todolist.infrastructure.ToDoListRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

  private final ToDoListRepository todoRepository;

  public ToDoListService(ToDoListRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public String findTodoByContent(Long id) {
    return findTodoById(id).getContent();
  }

  public Boolean findTodoByIsCompleted(Long id) {
    return findTodoById(id).getIsCompleted();
  }

  public LocalDateTime findTodoByCreateDateTime(Long id) {
    return findTodoById(id).getCreatedDateTime();
  }


  public List<ToDoList> getTodos(Sort sort) {
    return todoRepository.findAll(sort);
  }

  public void postTodo(ToDoList toDoList) {
    todoRepository.save(toDoList);
  }


  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }


  public ToDoList findTodoById(Long Id) {
    return todoRepository.findById(Id).orElse(new ToDoList());
  }


  public ToDoList createToDos(CreateToDoRequest createToDoRequest) {
    return createToDo(createToDoRequest);
  }

  public ToDoList updateToDo(UpdateToDoRequest updateToDoRequest) {
    return updateToDo(updateToDoRequest.getId(), updateToDoRequest);
  }

  public ToDoList createToDo(CreateToDoRequest createToDoRequest) {
    return ToDoList.builder()
        .content(createToDoRequest.getContent())
        .createdDateTime(LocalDateTime.now())
        .isCompleted(false)
        .build();
  }

  public ToDoList updateToDo(Long id, UpdateToDoRequest updateToDoRequest) {
    return ToDoList.builder()
        .id(id)
        .content(updateToDoRequest.getContent())
        .isCompleted(false)
        .createdDateTime(LocalDateTime.now())
        .build();
  }
}