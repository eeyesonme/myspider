package com.digitalplay.network.ireader.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AccountRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void findOne(){
		Account account = accountRepository.findOne(1L);
		
		account = accountRepository.findOne(2L);
		
		account = accountRepository.findOne(1L);
		
	}
}
