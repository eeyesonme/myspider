package com.digitalplay.network.ireader.repository;

import java.sql.Connection;

import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.Category;


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
		Session s1= openSession();
		s1.getTransaction().begin();
		s1.get(Category.class, 3L);
		s1.get(Category.class, 4L);
		s1.get(Category.class, 5L);
		s1.get(Category.class, 6L);
		s1.get(Category.class, 7L);
		s1.getTransaction().commit();
		s1.close();
		printStats();
		
		Session s2= openSession();
		s2.getTransaction().begin();
		String queryString = "update Category set name=? where id=?";
		Query  q= s2.createQuery(queryString);
		q.setString(0, "KKAK");
		q.setLong(1, 3L);
		q.setCacheable(true);
		q.executeUpdate();
		s2.get(Category.class, 3L);
		s2.get(Category.class, 4L);
		s2.get(Category.class, 5L);
		s2.get(Category.class, 6L);
		s2.get(Category.class, 7L);
		
		s2.getTransaction().commit();
		s2.close();
		printStats();
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	protected Connection  closeSession(Session s) {
		return	s.close();
	}
	
	public Author getAuthor(long id ,Session s ) {
		s.getTransaction().begin();
		final Author author = (Author) s.get( Author.class, id );
		s.getTransaction().commit();
		return author;
	}
	
	public Author loadAuthor(long id ,Session s) {
		s.getTransaction().begin();
		final Author author = (Author) s.load( Author.class, id );
		s.getTransaction().commit();
		return author;
	}
	
	public Book getBook(long id ,Session s) {
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
