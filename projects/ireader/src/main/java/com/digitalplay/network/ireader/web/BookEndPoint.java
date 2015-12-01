package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.service.BookService;
import com.digitalplay.network.ireader.util.MediaTypes;

@RestController
@RequestMapping(value = "/api/book")
public class BookEndPoint {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private Validator validator;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Book> list(Pageable pageable){
		Iterable<Book> book= bookService.findAll(pageable);
		ArrayList<Book> books= new ArrayList<Book>();
		while(book.iterator().hasNext()){
			books.add(book.iterator().next());
		}
		return books;
	}
}
