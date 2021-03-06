package com.digitalplay.network.ireader.repository;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.book.domain.Author;
import com.digitalplay.network.ireader.book.repository.AuthorRepository;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@Rollback(false)
public class AuthorRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private AuthorRepository authorDao;
	
	//@Test
	public void findAll(){
		Iterable<Author>  authors= authorDao.findAll();
		Iterator<Author> iter = authors.iterator();
		while(iter.hasNext()){
			Author author = iter.next();
			System.out.println(author.getId() + " has write " +author.getBooks().size());
		}
	}
	
	@Test
	public void testCreate(){
		Author author = new Author();
		author.setName("天蚕土豆");
		author.setEmail("tctd@hotmail.com");
		author.setSex("F");
		author.setStatus("AAAA");
		authorDao.save(author);
	}
}
