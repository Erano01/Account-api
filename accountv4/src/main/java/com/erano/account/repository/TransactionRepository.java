package com.erano.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erano.account.model.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{
	
}
