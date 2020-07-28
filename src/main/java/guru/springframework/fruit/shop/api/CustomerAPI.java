package guru.springframework.fruit.shop.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import guru.springframework.fruit.shop.constants.ShopConstants;
import guru.springframework.fruit.shop.models.CustomerDTO;
import guru.springframework.fruit.shop.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Customer API")
@RestController
@RequestMapping(ShopConstants.CUSTOMER_URL)
public class CustomerAPI {

	private final CustomerService customerService;
	
	
	public CustomerAPI(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@ApiOperation(value = "List of customers")
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<CustomerDTO> getCustomers(){
		return customerService.getCustomers();
	}
	
	@ApiOperation(value = "Find customer by id")
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("{id}")
	public CustomerDTO findCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	@ApiOperation(value = "Create new customer")
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public CustomerDTO create(@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.create(customerDTO);
	}
	
	@ApiOperation(value = "Update the customer")
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("{id}")
	public CustomerDTO update(@PathVariable("id") Long id,@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.update(id,customerDTO);
	}
		
	@ApiOperation(value = "Delete the customer")
	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		customerService.delete(id);
	}
	
	@ApiOperation(value = "Update part of customers", notes = "You can update only first name or only last name or both in same time")
	@ResponseStatus(value = HttpStatus.OK)
	@PatchMapping("{id}")
	public CustomerDTO patchCustomer(@PathVariable Long id,@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.patchCustomer(id, customerDTO);
	}
}
