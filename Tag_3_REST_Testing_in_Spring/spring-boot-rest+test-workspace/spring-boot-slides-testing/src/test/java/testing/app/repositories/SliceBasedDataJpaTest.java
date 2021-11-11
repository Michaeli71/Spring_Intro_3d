package testing.app.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import testing.app.entities.ToDo;

/*
# für city
#spring.jpa.hibernate.ddl-auto=none

# für Todo
#spring.jpa.hibernate.ddl-auto=create-drop
*/
@DataJpaTest
public class SliceBasedDataJpaTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private ToDoRepository repository;

	@Test
	public void todoDataTest() throws Exception {
		em.persist(new ToDo("Mail @ Anne"));

		var todos = repository.findByDescription("Mail @ Anne");
		
		assertThat(todos).contains(new ToDo("Mail @ Anne"));
	}
}
