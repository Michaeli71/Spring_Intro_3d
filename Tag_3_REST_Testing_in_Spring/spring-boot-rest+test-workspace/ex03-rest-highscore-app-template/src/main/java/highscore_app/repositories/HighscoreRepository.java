package highscore_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import highscore_app.entities.Highscore;

public interface HighscoreRepository extends JpaRepository<Highscore, Long> {

	List<Highscore> findByName(String name);
}