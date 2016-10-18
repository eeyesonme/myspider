package com.digitalplay.network.ireader.repository.sys;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Account;

public interface AccountRepository extends PagingAndSortingRepository<User, Long> , BatchRepository<User> {

	public User findByMobile(String mobile);
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);
}
