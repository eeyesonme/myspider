package com.digitalplay.network.ireader.repository;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BookRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void list() throws Exception {
		PageRequest page = new PageRequest(0,5);
		Page<Book> bookPage =bookRepository.findAll(page);
		Iterator<Book> iter = bookPage.iterator();
		while (iter.hasNext()){
			Book book= iter.next();
			Author author =  book.getAuthor();
			System.out.println("Book: id[" + book.getId()+"] ,Name["+ book.getName()+"] ,Author["+ author.getName()+"]");
		}
	}
}
