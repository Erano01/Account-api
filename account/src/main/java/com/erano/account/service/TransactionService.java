package com.erano.account.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erano.account.model.Account;
import com.erano.account.model.Transaction;
import com.erano.account.repository.TransactionRepository;

public class TransactionService {
	
	private Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	private final TransactionRepository transactionRepository;

	public TransactionService(Logger logger, TransactionRepository transactionRepository) {
		super();
		this.logger = logger;
		this.transactionRepository = transactionRepository;
	}
	
	protected Transaction initiateMoney(final Account account,BigDecimal amount) {
		
		return transactionRepository.save(
				new Transaction(amount,account)
				);
		
	}

}
