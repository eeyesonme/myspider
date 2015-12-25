package com.digitalplay.network.ireader.repository;

import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;
import org.junit.Assert;
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
	
	
//	@Test
	public void testHibernateLoadAndGet(){
		Session s= openSession();
		
		Author author = (Author) s.get( Author.class, 3L );
		Hibernate.initialize(author.getBooks()); 
		
		 author = (Author) s.load( Author.class, 3L );
		Hibernate.initialize(author);
		
	/*	
		Assert.assertTrue(author instanceof HibernateProxy);
		printStats();*/
//		s.getTransaction().commit();
		
		 s.clear();
		 try{
			 System.out.println("Get Author after Author Loaded, ATTEMPT #2");
			 author = (Author) s.get( Author.class, 1L );
		 }catch(ObjectNotFoundException ex){
			 System.out.println("Author Not found!");
		 }
		
		
	}
	@Test
	public void testHibernateCache(){
		Author author = getAuthor(1L);
		author.getBooks().get(0).getName();
		printStats();
		
		author = getAuthor(1L);
		author.getBooks().get(0).getName();
		printStats();
		
		
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	public Author getAuthor(long id ) {
		Session s= openSession();
		s.getTransaction().begin();
		final Author author = (Author) s.get( Author.class, id );
		s.getTransaction().commit();
		return author;
	}
	
	public Author loadAuthor(long id ) {
		Session s= openSession();
		s.getTransaction().begin();
		final Author author = (Author) s.load( Author.class, id );
		s.getTransaction().commit();
		return author;
	}
	
	public Book getBook(long id ) {
		Session s= openSession();
		s.getTransaction().begin();
		final Book book = (Book) s.get( Book.class, id );
		s.getTransaction().commit();
		return book;
	}
	
	public void printStats() {
		System.out.println("2lc put count: " + sessionFactory.getStatistics().getSecondLevelCachePutCount());
		System.out.println("2lc hit count: " + sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println("2lc miss count: " + sessionFactory.getStatistics().getSecondLevelCacheMissCount());
	}
}
