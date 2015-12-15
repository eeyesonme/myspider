package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.service.AuthorService;
import com.digitalplay.network.ireader.util.MediaTypes;

@RestController
public class AuthorEndPoint {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "/api/authors", produces = MediaTypes.JSON_UTF_8)
	public List<Author> listAllUser(Pageable pageable){
		Iterable<Author> authors =authorService.findAll(pageable);
		List<Author> authorList = new ArrayList<Author>();
		Iterator<Author> iter = authors.iterator();
		while(iter.hasNext()){
			authorList.add(iter.next());
		}
		return authorList;
	}
	
	@RequestMapping(value="/api/author/{id}" ,method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Author getAuthor(@PathVariable("id") Long id){
		Author author= authorService.findOne(id);
		return author;
	}
}
