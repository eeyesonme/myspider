package com.digitalplay.network.ireader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired 
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	public Iterable<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}
	
	public Account findOne(Long id){
		return accountRepository.findOne(id);
	}
}
