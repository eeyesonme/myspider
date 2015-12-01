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
import com.digitalplay.network.ireader.domain.AccountSubscribe;
import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.domain.Role;
import com.digitalplay.network.ireader.domain.Tag;
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
		System.out.println("Account ID/Name " + account.getId()+"/"+ account.getUsername());
		System.out.println(" The Account roles: ");
		List<Role> roles = account.getRoles();
		for(Role r : roles){
			System.out.println("								role "+ r.getName()+":"+ r.getPermissions());
		}
		System.out.println(" The Account  subscribed  books: ");
		List<AccountSubscribe> subscribes = account.getSubscribes();
		for (AccountSubscribe as : subscribes ){
			Book book = as.getBook();
			System.out.println("														 The Book Id/Name "+ book.getId()+ "/"+ book.getName());
			Author author =book.getAuthor();
			System.out.println("														 The Book Author Id/Name : "+ author.getId() + "/"+ author.getName());
			Category category =book.getCategory();
			System.out.println("														 The Book Category: "+category.getName());
			System.out.println("														 The Book Tags: ");
			List<Tag> bookTags= book.getBookTags();
			for(Tag tag: bookTags){
					System.out.println("                                                                          Tag Id/Name "+tag.getId()+"/"+tag.getName());
			}
		}
		return account;
	}
}
