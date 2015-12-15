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
		System.out.println("GET Author, ATTEMPT #1");
		Author author = getAuthor(1L);
		printStats();
		
		System.out.println("GET Author, ATTEMPT #2");
		 author = getAuthor(1L);
		printStats();
		
		System.out.println("GET Author, ATTEMPT #3");
		 author = getAuthor(1L);
		printStats();
		
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	public Author getAuthor(long id ) {
		Session s= openSession();
		final Author author = (Author) s.get( Author.class, id );
		if (!s.getTransaction().wasCommitted())
			s.getTransaction().commit();
		return author;
	}
	
	public Book getBook(long id ) {
		Session s= openSession();
		s.getTransaction().begin();
		final Book book = (Book) s.get( Book.class, id );
		if (!s.getTransaction().wasCommitted())
				s.getTransaction().commit();
		return book;
	}
	
	public void printStats() {
		System.out.println("2lc put count: " + sessionFactory.getStatistics().getSecondLevelCachePutCount());
		System.out.println("2lc hit count: " + sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println("2lc miss count: " + sessionFactory.getStatistics().getSecondLevelCacheMissCount());
	}
}
