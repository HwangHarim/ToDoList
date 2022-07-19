package com.RaiseMeUp.HH;

import com.RaiseMeUp.HH.todolist.domain.ToDoList;
import com.RaiseMeUp.HH.todolist.infrastructure.ToDoListRepository;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HhApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ToDoListRepository toDoListRepository) {
		return (args) -> {
			IntStream.rangeClosed(1, 10).forEach(index -> toDoListRepository.save(ToDoList.builder()
					.content("오늘 할 일" + index)
					.createdDateTime(LocalDateTime.now())
					.isCompleted(false)
					.build())
			);
		};
	}
}
