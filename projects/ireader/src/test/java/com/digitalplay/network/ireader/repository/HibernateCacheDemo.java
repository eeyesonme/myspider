package com.digitalplay.network.ireader.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;

@ContextConfiguration(locations = { "/applicationContext_jdbc.xml"})
public class HibernateCacheDemo extends AbstractJUnit4SpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testHibernateCache(){
		Session session1 = sessionFactory.openSession();
		Transaction t1 =session1.beginTransaction();
		Author author = getAuthor(1L,session1);
		t1.commit();
		session1.close();
	}
	
	public Author getAuthor(long id ,final Session s) {
		final Author author = (Author) s.get( Author.class, id );
		s.getTransaction().commit();
		return author;
	}
	
	public Book getBook(long id ,final Session s) {
		s.getTransaction().begin();
		final Book book = (Book) s.get( Book.class, id );
		s.getTransaction().commit();
		return book;
	}
}
