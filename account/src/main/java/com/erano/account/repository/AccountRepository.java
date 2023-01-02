package com.erano.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erano.account.model.Account;
import org.springframework.stereotype.Repository;

import java.util.function.LongFunction;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
}
