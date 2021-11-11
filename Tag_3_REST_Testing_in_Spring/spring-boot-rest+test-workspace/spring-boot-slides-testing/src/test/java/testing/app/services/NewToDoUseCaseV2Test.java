package testing.app.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import testing.app.entities.ToDo;
import testing.app.repositories.ToDoRepository;

public class NewToDoUseCaseV2Test {

	private ToDoRepository todoRepository = Mockito.mock(ToDoRepository.class);

	private NewToDoUseCaseV2 newToDoUseCaseV2;

	@BeforeEach
	void initUseCase() {
		newToDoUseCaseV2 = new NewToDoUseCaseV2(todoRepository);
		
		when(todoRepository.save(Mockito.any(ToDo.class))).
		then(AdditionalAnswers.returnsFirstArg());
	}

	@Test
	void savedToDoHasCreationDate() {
		ToDo toDo = new ToDo("Solve Exercises");
		
		ToDo savedToDo = newToDoUseCaseV2.createTodo(toDo);
		
		assertThat(savedToDo.getCreatedAt()).isNotNull();
	}
}
