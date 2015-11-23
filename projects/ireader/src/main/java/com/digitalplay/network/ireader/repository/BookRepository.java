package com.digitalplay.network.ireader.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

	List<Author> findByTitle(String title, Pageable pageable);
	
}
