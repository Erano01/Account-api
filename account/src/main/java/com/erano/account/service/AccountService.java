package com.erano.account.service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.erano.account.dto.AccountDto;
import com.erano.account.dto.AccountDtoConverter;
import com.erano.account.dto.CreateAccountRequest;
import com.erano.account.model.Account;
import com.erano.account.model.Customer;
import com.erano.account.model.Transaction;
import com.erano.account.repository.AccountRepository;

@Service
public class AccountService {
	
	/*IAccountService gi interfacelar oluşturma. çünkü bunun yapılmasının nedeni:
	Spring içersindeki DI ve IoC ile bu interface a gerek kalmadan
	bu injectionu yapabilmenizi sağlıyor. ama design pattern kullancaksan
	interface kullanabilirsin.
	amacımız service'i dışarıya expose etmekse interfaceye gerek yok
	
	autowired yapma.çünkü immutable olmuyor o zaman aşağıdaki field
	testibility da düşürüyor. Mockda buna göre yazmamız gerekiyor autowired ypaınca*/

	private final AccountRepository accountRepository;
	private final CustomerService customerService;
    private final AccountDtoConverter converter;
    private final Clock clock;
    
    private final TransactionService transactionService;
	
    public AccountService(AccountRepository accountRepository,
            CustomerService customerService,
            AccountDtoConverter converter, 
            Clock clock,
            TransactionService transactionService) {
    	
    	this.accountRepository = accountRepository;
    	this.customerService = customerService;
    	this.converter = converter;
    	this.clock = clock;
    	this.transactionService = transactionService;
    }
	
    
    
	public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                getLocalDateTimeNow());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    account);

            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }
	private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
	
	
	
}
