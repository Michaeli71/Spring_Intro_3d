package testing.app.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testing.app.entities.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

	Collection<ToDo> findByDescription(String string);
}
