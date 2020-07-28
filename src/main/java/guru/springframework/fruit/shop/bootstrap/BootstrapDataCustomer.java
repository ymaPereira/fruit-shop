package guru.springframework.fruit.shop.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import guru.springframework.fruit.shop.domains.Customer;
import guru.springframework.fruit.shop.repositories.CustomerRepository;

@Component
public class BootstrapDataCustomer implements ApplicationListener<ContextRefreshedEvent> {

	private final CustomerRepository customerRepository;

	public BootstrapDataCustomer(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.saveCustomers();
	}

	private void saveCustomers() {
		System.out.println("Saving Customers Data...");
		// given
		Customer customer1 = new Customer();
		customer1.setId(1l);
		customer1.setFirstName("Michale");
		customer1.setLastName("Weston");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setId(2l);
		customer2.setFirstName("Sam");
		customer2.setLastName("Axe");

		customerRepository.save(customer2);

		System.out.println("Total Customers: " + customerRepository.count());
	}
}
