package com.digitalplay.network.ireader.repository;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class AuthorRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Test
	public void findAll(){
		Iterable<Author>  authors= authorRepository.findAll();
		Iterator<Author> iter = authors.iterator();
		while(iter.hasNext()){
			Author author = iter.next();
			System.out.println(author.getId() + " has write " +author.getBooks().size());
		}
	}
}
