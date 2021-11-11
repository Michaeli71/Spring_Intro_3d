package testing.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleHelloWorldController {

	@GetMapping("/")
	public String greeting() {
		return "Hello, World";
	}
}
