package testing.app.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

@RestClientTest(UserDetailsClient.class)
public class UserDetailsClientTest {

    @Autowired
    private UserDetailsClient userDetailsClient;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    public void shouldReturnEmployeeDetailsFromHttpRequest() {
        String detailsPath = "http://localhost:8080/1/details";
		mockRestServiceServer.expect(requestTo(detailsPath)).andRespond(
                withSuccess(new ClassPathResource("userDetails.json"), MediaType.APPLICATION_JSON));

        UserDetails userDetails = userDetailsClient.getUserDetails(1);

        assertThat(userDetails.getAddress()).isEqualTo("Zürich");
        assertThat(userDetails.getSalary()).isEqualTo(100_000);
    }
}
