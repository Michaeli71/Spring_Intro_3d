package highscore_app;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import highscore_app.entities.Highscore;
import highscore_app.repositories.HighscoreRepository;

@SpringBootApplication
public class HighscoreServerApp {

	private static final Logger log = LoggerFactory.getLogger(HighscoreServerApp.class);

	public static void main(String[] args) {
		SpringApplication.run(HighscoreServerApp.class, args);
	}

	@Bean
	public CommandLineRunner demo(HighscoreRepository repository) {
		return (args) -> {

			repository.save(new Highscore("Jack", 1234, 4, LocalDate.of(2020, 3, 12)));
			repository.save(new Highscore("Tim", 2234, 5, LocalDate.of(2020, 3, 27)));
			repository.save(new Highscore("Michael", 7271, 7, LocalDate.of(2021, 2, 7)));
			repository.save(new Highscore("Peter", 7500, 6, LocalDate.of(2021, 1, 20)));
			repository.save(new Highscore("Michael", 721, 3, LocalDate.of(2019, 11, 24)));
			repository.save(new Highscore("Sophie", 2020, 4, LocalDate.of(2020, 11, 23)));

			// fetch all customers
			log.info("Highscore found with findAll():");
			log.info("-------------------------------");
			for (Highscore highscore : repository.findAll()) {
				log.info(highscore.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Highscore> optHighscore = repository.findById(1L);
			if (optHighscore.isPresent()) {
				Highscore highscore = optHighscore.get();
				log.info("Highscore found with findById(1L):");
				log.info("--------------------------------");
				log.info(highscore.toString());
				log.info("");
			}

			log.info("Highscore found with findByName('Michael'):");
			log.info("--------------------------------------------");
			repository.findByName("Michael").forEach(bauer -> {
				log.info(bauer.toString());
			});

		};
	}
}