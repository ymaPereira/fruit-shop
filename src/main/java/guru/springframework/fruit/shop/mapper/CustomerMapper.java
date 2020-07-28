package guru.springframework.fruit.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import guru.springframework.fruit.shop.domains.Customer;
import guru.springframework.fruit.shop.models.CustomerDTO;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "customerUrl", expression = "java(guru.springframework.fruit.shop.constants.ShopConstants.CUSTOMER_URL+\"/\"+customer.getId())")
	CustomerDTO customerToCustomerDTO(Customer customer);
	
	Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
