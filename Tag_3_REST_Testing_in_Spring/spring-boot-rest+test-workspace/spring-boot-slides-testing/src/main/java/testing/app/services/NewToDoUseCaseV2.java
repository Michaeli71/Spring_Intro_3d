package testing.app.services;

import org.springframework.stereotype.Service;

import testing.app.entities.ToDo;
import testing.app.repositories.ToDoRepository;

@Service
public class NewToDoUseCaseV2 {

	private final ToDoRepository todoRepository;

	public NewToDoUseCaseV2(ToDoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public ToDo createTodo(ToDo newTodo) {
		return todoRepository.save(newTodo);
	}
}
