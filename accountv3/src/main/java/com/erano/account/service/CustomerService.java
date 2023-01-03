package com.erano.account.service;

import com.erano.account.dto.CustomerDto;
import com.erano.account.dto.CustomerDtoConverter;
import com.erano.account.exception.CustomerNotFoundException;
import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

//SOLID = Single Responsibility
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final CustomerDtoConverter customerDtoConverter;
	public CustomerService(CustomerRepository customerRepository,
						   CustomerDtoConverter customerDtoConverter) {

		this.customerRepository=customerRepository;
		this.customerDtoConverter=customerDtoConverter;
	}
	
	//protected -> sadece paket içi
	//private -> sadece class içi
	//public -> heryere açık
	protected Customer findCustomerById(String id) {
		 return customerRepository.findById(id)
				.orElseThrow(
						() -> new CustomerNotFoundException("Customer could not find by id: "+id));
	}
	public CustomerDto getCustomerById(String customerId){
		return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
	}
}
