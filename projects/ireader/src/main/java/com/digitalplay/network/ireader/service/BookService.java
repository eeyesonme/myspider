package com.digitalplay.network.ireader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;


	@Transactional(readOnly = true)
	public Iterable<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Book findOne(Long id) {
		return bookRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Author> listBookByTtile(String  title, Pageable pageable) {
		return bookRepository.findByTitle(title, pageable);
	}

}
