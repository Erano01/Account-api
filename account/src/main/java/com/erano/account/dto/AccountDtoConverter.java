package com.erano.account.dto;

import java.util.Objects;
import java.util.stream.Collectors;

import com.erano.account.model.Account;

public class AccountDtoConverter {
	
	private final CustomerDtoConverter customerDtoConverter;
	private final TransactionDtoConverter transactionDtoConverter;
	
	
	public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,TransactionDtoConverter transactionDtoConverter) {
		this.customerDtoConverter = customerDtoConverter;
		this.transactionDtoConverter=transactionDtoConverter;
	}



	public AccountDto convert(Account from) {
		return new AccountDto(from.getId(),
				from.getBalance(),
				from.getCreationDate(),
				customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
				Objects.requireNonNull(from.getTransaction())
						.stream()
						.map(t -> transactionDtoConverter.convert(t))
						.collect(Collectors.toSet())
				);
	}
}
