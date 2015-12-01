package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
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
	
	@RequestMapping(value="/api/books/" ,method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Book> list(Pageable pageable){
		Iterable<Book> book= bookService.findAll(pageable);
		ArrayList<Book> books= new ArrayList<Book>();
		while(book.iterator().hasNext()){
			books.add(book.iterator().next());
		}
		return books;
	}
	
	@RequestMapping(value="/api/book/{id}" ,method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Book getBook(@PathVariable("id") Long id){
		Book book= bookService.findOne(id);
		System.out.println("														 The Book Id/Name "+ book.getId()+ "/"+ book.getName());
		Author author =book.getAuthor();
		System.out.println("														 The Book Author Id/Name : "+ author.getId() + "/"+ author.getName());
		Category category =book.getCategory();
		System.out.println("														 The Book Category: "+category.getName());
		System.out.println("														 The Book Tags: ");
		List<Tag> bookTags= book.getBookTags();
		for(Tag tag: bookTags){
				System.out.println("                                                                          Tag Id/Name "+tag.getId()+"/"+tag.getName());
		}
		return book;
	}
}
