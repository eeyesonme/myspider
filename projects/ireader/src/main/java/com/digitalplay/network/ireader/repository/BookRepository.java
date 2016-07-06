package com.digitalplay.network.ireader.repository;


import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> , JpaSpecificationExecutor<Book>,BatchRepository<Book>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Book> findByCategoryNameOrderByIdDesc(String name,Pageable page);
}
