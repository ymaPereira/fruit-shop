package guru.springframework.fruit.shop.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import guru.springframework.fruit.shop.domains.Customer;
import guru.springframework.fruit.shop.mapper.CustomerMapper;
import guru.springframework.fruit.shop.models.CustomerDTO;
import guru.springframework.fruit.shop.repositories.CustomerRepository;
import guru.springframework.fruit.shop.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;	
	
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		super();
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getCustomers() {		
		return customerRepository.findAll().stream().map(customerMapper::customerToCustomerDTO).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO create(CustomerDTO customerDTO) {
		return customerMapper.customerToCustomerDTO(customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO)));
	}

	@Override
	public CustomerDTO update(Long id, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		customer.setId(id);
		return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
	}

	@Override
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public CustomerDTO getCustomer(Long id) {
		return customerMapper.customerToCustomerDTO(customerRepository.findById(id).orElse(null));
	}

	@Override
	public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(id).orElse(null);
		if(customer != null && customerDTO != null) {
			if(customerDTO.getFirstName() != null) {
				customer.setFirstName(customerDTO.getFirstName());
			}
			if(customerDTO.getLastName() != null) {
				customer.setLastName(customerDTO.getLastName());
			}
			return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
		}
		return null;
	}

	

}
