package com.digitalplay.network.ireader.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> ,BatchRepository<Category>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Category> findByNameOrderByIdAsc(String name,Pageable page);
	
	
}
