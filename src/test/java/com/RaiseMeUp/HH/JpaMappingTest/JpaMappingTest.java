package com.RaiseMeUp.HH.JpaMappingTest;

import static org.hamcrest.MatcherAssert.assertThat;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.infrastructure.ToDoListRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DataJpaTest

public class JpaMappingTest {
  public final String content = "내용";

  @Autowired
  private ToDoListRepository toDoListRepository;

  @Autowired
  private TestEntityManager em;

  private ToDoList getSaved() {
    ToDoList todo = ToDoList.builder()
        .content(content)
        .createdDateTime(LocalDateTime.now())
        .build();

    return em.persist(todo);
  }

  @Test
    public void 출력() throws Exception{
      //given
    ToDoList todolist = getSaved();
    System.out.println("=========================");
    System.out.println(todolist.getId());
    System.out.println(todolist.getContent());
    System.out.println(todolist.getIsCompleted());
    System.out.println(todolist.getCreatedDateTime());
    System.out.println("=========================");
    Long id = todolist.getId();
      //when
    ToDoList savedTodo = toDoListRepository.getOne(id);
      //tnen

    }
}
