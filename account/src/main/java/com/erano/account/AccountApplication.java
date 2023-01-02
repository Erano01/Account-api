package com.erano.account;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erano.account.model.Customer;
import com.erano.account.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountApplication {

	@Autowired
	private CustomerRepository customerRepository;

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			Customer customer = customerRepository.save(new Customer(null,"Hüseyin","wqeewq",new HashSet<>()));
			System.out.println(customer);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
