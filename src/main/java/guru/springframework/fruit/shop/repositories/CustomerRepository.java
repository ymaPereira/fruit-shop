package guru.springframework.fruit.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import guru.springframework.fruit.shop.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
