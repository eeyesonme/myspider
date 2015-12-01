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
		List<Role> roles = account.getRoles();
		Iterator<Role> roleIter = roles.iterator();
		while (roleIter.hasNext()){
			Role role = roleIter.next();
			System.out.println(role.getName()+":"+ role.getPermissions());
		}
		List<AccountSubscribe> subscribes = account.getSubscribes();
		Iterator<AccountSubscribe> scribeIter = subscribes.iterator();
		while(scribeIter.hasNext()){
			AccountSubscribe subscribe = scribeIter.next();
			Book book = subscribe.getBook();
			Author author =book.getAuthor();
			System.out.println("Book ID/Name : "+ author.getId() + "/"+ author.getName());
			Category category =book.getCategory();
			System.out.println("Book Category: "+category.getName());
			List<Tag> bookTags= book.getBookTags();
			for(Tag tag: bookTags){
				System.out.println(tag.getId()+":"+tag.getName());
			}
			
		}
		return account;
	}
}
