package testing.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import testing.app.controllers.SimpleHelloWorldController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private SimpleHelloWorldController controller;

	@Test
	public void appContextCorrectlyLoaded() {
		assertThat(controller).isNotNull();
	}
}
