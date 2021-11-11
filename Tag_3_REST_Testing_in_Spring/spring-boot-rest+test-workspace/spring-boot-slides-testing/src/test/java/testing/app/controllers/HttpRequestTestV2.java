package testing.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTestV2 {

	@LocalServerPort
	private int port;

	@Test
	public void greetingShouldReturnDefaultMessage() {
		
		RestAssured.given().
		when().get("http://localhost:" + port + "/").
		then().
		assertThat().statusCode(200).and().
		             toString().contains("Hello, World");
	}
}
