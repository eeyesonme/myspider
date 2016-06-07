package com.digitalplay.network.ireader.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.domain.AccountRole;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@Rollback(false)
public class AccountRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private AccountRepository accountDao;
	
	
	@Test
	public void  testDeleteAccount() throws Exception {
		
		Account account = accountDao.findOne(1L);
		List<AccountRole> roles = account.getRoles();
		for(AccountRole role : roles){
			assert(role != null);
		}
		account.getRoles().clear();
		
		accountDao.delete(account);
		
	}
}
