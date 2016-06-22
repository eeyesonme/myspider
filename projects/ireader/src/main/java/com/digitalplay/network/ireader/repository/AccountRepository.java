package com.digitalplay.network.ireader.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> , BatchRepository<Account> {

	public Account findByMobile(String mobile);
	
	public Account findByEmail(String email);
}
