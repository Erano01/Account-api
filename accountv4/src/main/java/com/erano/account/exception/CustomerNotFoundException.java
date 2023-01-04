package com.erano.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.erano.account.model.Customer;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
