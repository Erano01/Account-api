package com.erano.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erano.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	
}
