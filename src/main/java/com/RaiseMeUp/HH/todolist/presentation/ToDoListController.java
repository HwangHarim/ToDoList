package com.RaiseMeUp.HH.todolist.presentation;

import com.RaiseMeUp.HH.todolist.application.ToDoListService;
import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.dto.request.ToDoListRequestDto;
import com.RaiseMeUp.HH.todolist.todolistconverter.ToDoListConverter;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

@ApiResponses({
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoListController {

  private final ToDoListService toDoListService;
  private ToDoListConverter converter;

  public ToDoListController(ToDoListService toDoListService) {
    this.toDoListService = toDoListService;
  }

  @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
  public ResponseEntity<?> getTodos() {
    List<ToDoList> toDoLists = toDoListService.getTodos(Sort.by(Direction.ASC, "id"));
    return ResponseEntity.ok(toDoLists);
  }

  @PostMapping
  public ResponseEntity<String> postToDo(@RequestBody ToDoListRequestDto toDoListRequestDto) {
    toDoListService.postTodo(toDoListService.createToDo(toDoListRequestDto));
    return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> putToDo(@PathVariable("id") Long id){
    toDoListService.postTodo(toDoListService.updateToDo(converter.toToDoRequestDto(id,toDoListService.findTodoByContent(id),
        toDoListService.findTodoByIsCompleted(id), toDoListService.findTodoByCreateDateTime(id))));
    return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteToDo(@PathVariable("id") Long id){
    toDoListService.deleteTodo(id);
    return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
  }
}