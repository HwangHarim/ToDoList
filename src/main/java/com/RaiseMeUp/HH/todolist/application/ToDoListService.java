package com.RaiseMeUp.HH.todolist.application;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.dto.request.ToDoListRequestDto;
import com.RaiseMeUp.HH.todolist.infrastructure.ToDoListRepository;
import com.RaiseMeUp.HH.todolist.todolistconverter.ToDoListConverter;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

  private final ToDoListRepository todoRepository;
  private ToDoListConverter converter;

  public ToDoListService(ToDoListRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public String findTodoByContent(Long id){
    return findTodoById(id).getContent();
  }
  public Boolean findTodoByIsCompleted(Long id){
    return findTodoById(id).getIsCompleted();
  }
  public LocalDateTime findTodoByCreateDateTime(Long id){
    return findTodoById(id).getCreatedDateTime();
  }


  public List<ToDoList> getTodos(Sort sort) {
    return todoRepository.findAll(sort);
  }

  public void postTodo(ToDoList toDoList){
     todoRepository.save(toDoList);
  }


  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }


  public ToDoList findTodoById(Long Id) {
    return todoRepository.findById(Id).orElse(new ToDoList());
  }

  public ToDoList createToDo(ToDoListRequestDto toDoListRequestDto){
   return converter.createToDo(
     toDoListRequestDto.getId(),
     toDoListRequestDto.getContent(),
       toDoListRequestDto.getCompleted(),
       toDoListRequestDto.getCreatedDateTime());
  }

  public ToDoList updateToDo(ToDoListRequestDto toToDoListRequestDto){
    return converter.updateToDo(toToDoListRequestDto.getId(),
        toToDoListRequestDto.getContent(),
        toToDoListRequestDto.getCompleted(),
        toToDoListRequestDto.getCreatedDateTime());
  }
}