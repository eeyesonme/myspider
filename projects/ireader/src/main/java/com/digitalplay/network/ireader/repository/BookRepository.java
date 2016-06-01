package com.digitalplay.network.ireader.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> , BatchRepository<Book>{

}
