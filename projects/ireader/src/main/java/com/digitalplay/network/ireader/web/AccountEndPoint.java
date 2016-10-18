package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.service.account.AccountService;
import com.digitalplay.network.ireader.util.MediaTypes;

@RestController
public class AccountEndPoint {

	@Autowired
	private AccountService accountServcie;
	
	@RequestMapping(value = "/api/accounts", produces = MediaTypes.JSON_UTF_8)
	public List<User> listAllUser(Pageable pageable){
		Iterable<User> accountIter =accountServcie.findAll(pageable);
		List<User> accounts = new ArrayList<User>();
		Iterator<User> iter = accountIter.iterator();
		while(iter.hasNext()){
			accounts.add(iter.next());
		}
		return accounts;
	}
	
	@RequestMapping(value = "/api/account/{id}", produces = MediaTypes.JSON_UTF_8)
	public User  getMyAccount(@PathVariable("id") Long id){
		User account =accountServcie.findOne(id);
		return account;
	}
}
