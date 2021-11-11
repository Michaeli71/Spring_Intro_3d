package testing.app.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsClient {

    private final RestTemplate restTemplate;

    public UserDetailsClient(RestTemplateBuilder restTemplateBuilder) {
    	restTemplate = restTemplateBuilder.build();
    }	

    public UserDetails getUserDetails(int id) {
        String detailsPath = "http://localhost:8080/{id}/details";
        return restTemplate.getForObject(detailsPath, UserDetails.class, id);
    }
}

class UserDetails {
    private String address;
    private int salary;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    
}