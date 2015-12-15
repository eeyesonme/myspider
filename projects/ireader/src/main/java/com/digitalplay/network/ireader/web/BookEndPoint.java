package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.domain.Tag;
import com.digitalplay.network.ireader.service.BookService;
import com.digitalplay.network.ireader.util.MediaTypes;

@RestController
public class BookEndPoint {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private Validator validator;
	
	@RequestMapping(value="/api/books" ,produces = MediaTypes.JSON_UTF_8)
	public List<Book> list(Pageable pageable){
		Iterable<Book> book= bookService.findAll(pageable);
		ArrayList<Book> books= new ArrayList<Book>();
		Iterator<Book> iter= book.iterator();
		while(iter.hasNext()){
			books.add(iter.next());
		}
		return books;
	}
	
	@RequestMapping(value="/api/book/{id}" ,method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Book getBook(@PathVariable("id") Long id){
		Book book= bookService.findOne(id);
		return book;
	}
}
