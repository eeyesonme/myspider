package com.digitalplay.network.ireader.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class RoleRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void findOne(){
		 roleRepository.findOne(1L);
	}
}
