package com.erano.account.service;

import com.erano.account.exception.CustomerNotFoundException;
import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

//SOLID = Single Responsibility
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	//protected -> sadece paket içi
	//private -> sadece class içi
	//public -> heryere açık

	protected Customer findCustomerById(Long id) {
		 return customerRepository.findById(id)
				.orElseThrow(
						() -> new CustomerNotFoundException("Customer could not find by id: "+id));
	}
}
