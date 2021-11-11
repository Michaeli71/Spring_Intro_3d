package testing.app.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String generateGreeting() {
		return "Hello, World";
	}
}
