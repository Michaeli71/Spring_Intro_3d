package testing.app.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

@JsonTest
public class UserDetailsJsonTest {

	@Autowired
	private JacksonTester<UserDetails> jsonSerializer;

	@Test
	public void testSerialize() throws Exception {

		UserDetails userDetails = new UserDetails(1L, "Duke", "Java", LocalDate.of(1995, 1, 1), true);

		JsonContent<UserDetails> result = this.jsonSerializer.write(userDetails);
		System.out.println("write: "  + result);
		
		assertThat(result).hasJsonPathStringValue("$.firstname");
		assertThat(result).extractingJsonPathStringValue("$.firstname").isEqualTo("Duke");
		assertThat(result).extractingJsonPathStringValue("$.lastname").isEqualTo("Java");
		assertThat(result).extractingJsonPathStringValue("$.dateofbirth").isEqualTo("01.01.1995");
		assertThat(result).doesNotHaveJsonPath("$.enabled");
	}

	@Test
	public void testDeserialize() throws Exception {

		String jsonContent = "{\"firstname\":\"Mike\", \"lastname\": \"Inden\"," + " \"dateofbirth\":\"07.02.1971\","
				+ " \"id\": 7271, \"enabled\": true}";

		UserDetails result = this.jsonSerializer.parse(jsonContent).getObject();
		System.out.println("parse: " + result);
		
		assertThat(result.getFirstName()).isEqualTo("Mike");
		assertThat(result.getLastName()).contains("den");
		assertThat(result.getDateOfBirth()).isAfter(LocalDate.of(1971, 01, 01));
		assertThat(result.getId()).isBetween(7000L, 8000L);
		assertThat(result.isEnabled()).isTrue();
	}
}
