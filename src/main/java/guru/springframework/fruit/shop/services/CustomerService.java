package guru.springframework.fruit.shop.services;

import java.util.List;
import guru.springframework.fruit.shop.models.CustomerDTO;

public interface CustomerService {

	List<CustomerDTO> getCustomers();
	
	CustomerDTO create(CustomerDTO customerDTO);
	
	CustomerDTO update(Long id,CustomerDTO customerDTO);
	
	void delete(Long id);
	
	CustomerDTO getCustomer(Long id);
	
	CustomerDTO patchCustomer(Long id,CustomerDTO customerDTO);
}
