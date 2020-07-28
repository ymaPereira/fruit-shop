package guru.springframework.fruit.shop.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
	
	@ApiModelProperty(value = "This is the first name", required = true)
	@JsonProperty("firstname")
	private String firstName;	
	@ApiModelProperty(value = "This is the last name", required = true)
	@JsonProperty("lastname")
	private String lastName;	
	@ApiModelProperty(value = "This is the customer url", required = false, notes = "This field is generated after created customer")
	@JsonProperty("customer_url")
	private String customerUrl;
}
