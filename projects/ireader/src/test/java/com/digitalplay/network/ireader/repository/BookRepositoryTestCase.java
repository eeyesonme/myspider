package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.BookContent;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(defaultRollback=false)
public class BookRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private BookRepository bookDao;

	@Autowired
	private BookContentRepository bookContentDao;
	

//@Test 
	public void testQuery() throws Exception {
	 
	Book book = bookDao.findOne(2L);
	book.getAuthor();
}
	
   @Test
	public void testDelete() throws Exception {
	Book book = bookDao.findOne(1L);
	List<BookContent> contents =book.getBookContents();
	List<Long> contentIds = new ArrayList<Long>(contents.size());
	assert(contents.size()!=0);
	for (BookContent content : contents){
		contentIds.add(content.getId());
	}
	contents.clear();
	bookDao.delete(book);
  for (Long id: contentIds){
	  BookContent content = bookContentDao.findOne(id);
	  assert(content==null);
  }
  }
  
  @Test
  public void testAdd() throws Exception {
	  Book bookFrom = bookDao.findOne(2L);
	  Book book =copyBook(bookFrom);
	  bookDao.save(book);
	  
  }
  
  @Test
  public void testUpdate() throws Exception {
	  Book book = bookDao.findOne(2L);
	  BookContent bc = new BookContent();
	  bc.setContentMain("test");
	  bc.setContentTitle("test");
	  book.addContent(bc);
	  bookDao.save(book);
  }
  
private Book copyBook(Book bookFrom) {
	Book book = new Book();
	book.setName(bookFrom.getName());
	book.setDescription(bookFrom.getDescription());
	book.setAuthor(bookFrom.getAuthor());
	book.setCategory(bookFrom.getCategory());
	List<BookContent> contentsFrom = bookFrom.getBookContents();
	for(BookContent content : contentsFrom){
		BookContent c= new BookContent();
		c.setContentTitle(content.getContentTitle());
		c.setContentMain(content.getContentMain());
		book.addContent(c);
	}
	return book;
}

}
