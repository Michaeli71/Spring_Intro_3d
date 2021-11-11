package testing.app.controllers.slicing;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import testing.app.controllers.GreetingController;
import testing.app.services.GreetingService;

@WebMvcTest(GreetingController.class)
public class SliceBasedGreetingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	// DEMO: Auskommentieren => "Service"s sind nicht zugreifbar im Slice Based Test,
	// DEMO: AUch @Autowired geht nicht
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