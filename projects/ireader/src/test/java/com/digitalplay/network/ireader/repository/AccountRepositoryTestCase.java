package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	
	
//	@Test
	public void  testDeleteAccount() throws Exception {
		
		User account = accountDao.findOne(1L);
		List<AccountRole> roles = account.getRoles();
		for(AccountRole role : roles){
			assert(role != null);
		}
		account.getRoles().clear();
		
		accountDao.delete(account);
		
	}
	
	
//	@Test
	public void testCreateAccount() throws Exception {
			Collection<User> entities = generateTestAccounts(1000);
			accountDao.batchInsert(entities);
	}
	
	
	private Collection<User> generateTestAccounts(int size){
		Collection<User> accounts = new ArrayList<User>(size);
		for (int i = 0; i <size;i++){
			User account = new User();
			account.setEmail("account-test"+i+"@ireader.com");
			account.setUsername("account-test"+i);
			account.setMobile("xxx-xxxx-xxxx");
			account.setPassword("ppppppp");
			account.setSalt("ieiorjmdfasoe23dls0094");
			accounts.add(account);
		}
		return accounts;
	}
}
