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

@RestController
@RequestMapping(ShopConstants.CUSTOMER_URL)
public class CustomerAPI {

	private final CustomerService customerService;
	
	
	public CustomerAPI(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping
	public List<CustomerDTO> getCustomers(){
		return customerService.getCustomers();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("{id}")
	public CustomerDTO findCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public CustomerDTO create(@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.create(customerDTO);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("{id}")
	public CustomerDTO update(@PathVariable("id") Long id,@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.update(id,customerDTO);
	}
		
	@ResponseStatus(value = HttpStatus.OK)
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		customerService.delete(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PatchMapping("{id}")
	public CustomerDTO patchCustomer(@PathVariable Long id,@RequestBody(required = true) CustomerDTO customerDTO) {
		return customerService.patchCustomer(id, customerDTO);
	}
}
