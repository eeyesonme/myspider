package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.BookContent;
import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
@Rollback(false)
public class BookRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private BookRepository bookDao;

	@Autowired
	private BookContentRepository bookContentDao;
	
	@Autowired
	private AuthorRepository authorDao;
	
	@Autowired 
	private CategoryRepository categoryDao;

//@Test 
	public void testQuery() throws Exception {
	 
	Book book = bookDao.findOne(2L);
	book.getAuthor();
}
	
   //@Test
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
  
  //@Test
  public void testCreate() throws Exception {
	  Book  book = new Book();
	  Author author = authorDao.findOne(2L);
	  book.setAuthor(author);
	  book.setName("武动乾坤");
	  book.setDescription("修炼一途，乃窃阴阳，夺造化，转涅盘，握生死，掌轮回。 武之极，破苍穹，动乾坤！");
	  Category category =categoryDao.findOne(1L);
	  book.setCategory(category);
	  BookContent bookContent = new BookContent();
	  bookContent.setContentTitle("第一章 林动");
	  bookContent.setContentMain("当林动费尽所有的力气睁开那有些沉重的眼皮时，简陋而整洁的房间顿时出现在眼中");
	  book.addContent(bookContent);
	  
	  bookDao.save(book);
	  
  }
  
  @Test
  public void testBatch() throws Exception {
	  Book bookFrom = bookDao.findOne(4L);
	  Collection<Book> books = new ArrayList<Book>(60);
	  
	  for(int i=0 ; i<50; i++){
		  Book book =copyBook(bookFrom);
		  books.add(book);
	  }
	  System.out.println("befroe save ,time: "+System.currentTimeMillis());
	  bookDao.batchInsert(books);
	  System.out.println("After save ,time: "+System.currentTimeMillis());
  }
  
 // @Test
  public void testUpdate() throws Exception {
	  Book book = bookDao.findOne(3L);
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
