package com.digitalplay.network.ireader.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.AccountRole;
import com.digitalplay.network.ireader.domain.Role;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class RoleRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void findOne(){
		Role role = roleRepository.findOne(1L);
		List<AccountRole> accounts =role.getAccount_roles();
		int size =accounts.size();
		System.out.println(size);
	}
}