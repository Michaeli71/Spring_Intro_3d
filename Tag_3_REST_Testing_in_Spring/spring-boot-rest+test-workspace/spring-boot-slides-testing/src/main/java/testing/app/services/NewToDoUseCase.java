package testing.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testing.app.entities.ToDo;
import testing.app.repositories.ToDoRepository;

@Service
public class NewToDoUseCase {

	@Autowired
	private ToDoRepository todoRepository;

	public ToDo createTodo(ToDo newTodo) {
		return todoRepository.save(newTodo);
	}
}
