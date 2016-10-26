package com.digitalplay.network.ireader.repository.book;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.book.BookContent;

public interface BookContentRepository extends PagingAndSortingRepository<BookContent, Long>{

}
