package com.erano.account.dto;

import org.springframework.stereotype.Component;

import com.erano.account.model.Transaction;

@Component
public class TransactionDtoConverter {
	
	public TransactionDto convert(Transaction from) {
		return new TransactionDto(from.getId(),
				from.getTransactionType(),
				from.getAmount(),
				from.getTransactionDate());
	}
}
