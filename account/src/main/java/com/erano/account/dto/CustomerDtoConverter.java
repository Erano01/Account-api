package com.erano.account.dto;

import org.springframework.stereotype.Component;

import com.erano.account.model.Customer;

@Component
public class CustomerDtoConverter {
	
	public AccountCustomerDto convertToAccountCustomer(Customer from) {
		if(from ==null) {
			return new AccountCustomerDto(1L,"","");
		}
		
		return new AccountCustomerDto(from.getId(),from.getName(),from.getSurname());
	}

}
