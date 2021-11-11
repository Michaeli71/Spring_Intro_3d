package testing.app.services;

import static org.mockito.Mockito.when;

import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import testing.app.entities.ToDo;
import testing.app.repositories.ToDoRepository;

public class NewToDoUseCaseV2ImprovedTest {

	private ToDoRepository todoRepository = Mockito.mock(ToDoRepository.class);

	private NewToDoUseCaseV2 newToDoUseCaseV2;

	@BeforeEach
	void initUseCase() {
		newToDoUseCaseV2 = new NewToDoUseCaseV2(todoRepository);

		when(todoRepository.save(Mockito.any(ToDo.class))).then(AdditionalAnswers.returnsFirstArg());
	}

	@Test
	void savedToDoHasCreationDate() {
		ToDo toDo = new ToDo("Solve Exercises");

		ToDo savedToDo = newToDoUseCaseV2.createTodo(toDo);

		ToDoAssert.assertThat(savedToDo).hasCreationDate();
	}
}

class ToDoAssert extends AbstractAssert<ToDoAssert, ToDo> {

	ToDoAssert(ToDo toDo) {
		super(toDo, ToDoAssert.class);
	}

	static ToDoAssert assertThat(ToDo actual) {
		return new ToDoAssert(actual);
	}

	public ToDoAssert hasCreationDate() {
		isNotNull();
		if (actual.getCreatedAt() == null) {
			failWithMessage("Expected ToDo to have a creation date, but it was null");
		}
		return this;
	}
}
