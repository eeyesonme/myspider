package com.digitalplay.network.ireader.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.BookContent;

public interface BookContentRepository extends PagingAndSortingRepository<BookContent, Long>{

}
