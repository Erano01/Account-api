package com.erano.account.repository;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erano.account.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
}
