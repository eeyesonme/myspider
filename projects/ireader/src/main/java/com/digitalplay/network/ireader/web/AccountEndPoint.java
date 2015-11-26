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
import com.digitalplay.network.ireader.domain.BookSubscribe;
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
	
	@RequestMapping(value = "/api/account/{id}", produces = MediaTypes.JSON_UTF_8)
	public Account  getMyAccount(@PathVariable("id") Long id){
		Account account =accountServcie.findOne(id);
		/*List<BookSubscribe> subscribes = account.getSubscribes();
		System.out.println(subscribes.size() +" had been subscribed!");
		Iterator<BookSubscribe> bsiter = subscribes.iterator();
		while(bsiter.hasNext()){
			BookSubscribe subscribe =bsiter.next();
			System.out.println("-------------------"+subscribe.getId() +"--"+subscribe.getSubscribe_time());
		}*/
		return account;
	}
}
