package com.RaiseMeUp.HH.todolist.presentation;

import com.RaiseMeUp.HH.todolist.application.ToDoListService;
import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class ToDoListController {

  private final ToDoListService toDoListService;

  public ToDoListController(ToDoListService toDoListService) {
    this.toDoListService = toDoListService;
  }

  /**
   * 목록 조회
   * @return ResponseEntity
   * **/
  @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
  public ResponseEntity<?>getTodoLists()throws Exception{
    List<ToDoList> toDoLists = toDoListService.getTodos(Sort.by(Direction.ASC,"id"));
    return ResponseEntity.ok(toDoLists);
  }

  @PostMapping
  public ResponseEntity<String> postToDoList(@RequestBody ToDoList todolist) throws Exception {
    todolist.setCreatedDateTime(LocalDateTime.now());
    todolist.setIsComplete(false);
    toDoListService.postTodo(todolist);
    return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> putToDoList(@PathVariable("id") Long id) throws Exception {
   ToDoList todolist = toDoListService.findTodoById(id);

    Boolean isComplete = todolist.getIsComplete() ? false : true;
    todolist.setIsComplete(isComplete);
    toDoListService.postTodo(todolist);

    return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteToDoList(@PathVariable("id") Long id) throws Exception {
    toDoListService.deleteTodo(id);
    return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
  }
}
