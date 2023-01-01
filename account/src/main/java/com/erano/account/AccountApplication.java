package com.erano.account;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	
	public AccountApplication(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		Customer customer = customerRepository.save(new Customer("","Hüseyin","wqeewq",new HashSet<>()));
		System.out.println(customer);
	}
}
