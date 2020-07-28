package guru.springframework.fruit.shop.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {
	
	@JsonProperty("firstname")
	private String firstName;
	@JsonProperty("lastname")
	private String lastName;
	@JsonProperty("customer_url")
	private String customerUrl;
}
