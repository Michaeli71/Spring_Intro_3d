package testing.app.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import testing.app.services.GreetingService;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// DEMO: Auskommentieren => Original wird verwendet
	@MockBean
	private GreetingService service;
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		
		when(service.generateGreeting()).thenReturn("CHANGED FOR TESTING");
		
		mockMvc.perform(get("/greeting")).
		        // andDo(print()).
		        andExpect(status().isOk()).
		        andExpect(content().string(containsString("CHANGED FOR TESTING")));
	}
}