package com.digitalplay.network.ireader.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.domain.Role;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AccountRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void findAll(){
		PageRequest page = new PageRequest(0,5);
		Page<Account> accountPage =accountRepository.findAll(page);
		Iterator<Account> iter = accountPage.iterator();
		while (iter.hasNext()){
			Account account= iter.next();
			List<Role> roleList =  account.getRoleList();
			System.out.println("Account["+account.getUsername()+"] are those roles :");
			for(Role role : roleList){
				System.out.println(role.getName() );
			}
			
		}
	}
}
