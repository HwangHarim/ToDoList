package com.RaiseMeUp.HH.todolist.application;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.dto.request.ToDoListRequestDto;
import com.RaiseMeUp.HH.todolist.dto.response.ToDoListResponseDto;
import com.RaiseMeUp.HH.todolist.infrastructure.ToDoListRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

  private final ToDoListRepository todoRepository;

  public ToDoListService(ToDoListRepository todoRepository) {
    this.todoRepository = todoRepository;
  }


  public List<ToDoList> getTodos(Sort sort) throws Exception {
    return todoRepository.findAll(sort);
  }

  public void postTodo(ToDoList toDoList){
     todoRepository.save(toDoList);
  }


  public void deleteTodo(Long id) throws Exception {
    todoRepository.deleteById(id);
  }


  public ToDoList findTodoById(Long Id) throws Exception {
    return todoRepository.findById(Id).orElse(new ToDoList());
  }

}
