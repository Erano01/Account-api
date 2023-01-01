package com.erano.account.service;

import com.erano.account.exception.CustomerNotFoundException;
import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;

//SOLID = Single Responsibility
public class CustomerService {

	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	//protected -> sadece paket içi
	//private -> sadece class içi
	//public -> heryere açık
	protected Customer findCustomerById(String id) {
		 return customerRepository.findById(id)
				.orElseThrow(
						() -> new CustomerNotFoundException("Customer could not find by id: "+id));
	}
}
