package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.service.AccountService;
import com.digitalplay.network.ireader.util.MediaTypes;

@RestController
public class AccountEndPoint {

	@Autowired
	private AccountService accountServcie;
	
	@RequestMapping(value = "/api/accounts", produces = MediaTypes.JSON_UTF_8)
	public List<Account> listAllUser(Pageable pageable){
		Iterable<Account> accountIter =accountServcie.findAll(pageable);
		List<Account> accounts = new ArrayList<Account>();
		while(accountIter.iterator().hasNext()){
			accounts.add(accountIter.iterator().next());
		}
		return accounts;
	}
}
