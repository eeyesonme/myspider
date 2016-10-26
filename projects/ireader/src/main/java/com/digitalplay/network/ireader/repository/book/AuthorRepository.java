package com.digitalplay.network.ireader.repository.book;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.book.Author;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

}
