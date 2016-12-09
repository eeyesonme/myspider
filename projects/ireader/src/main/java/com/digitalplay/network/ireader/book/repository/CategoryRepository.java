package com.digitalplay.network.ireader.book.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.book.domain.Category;
import com.digitalplay.network.ireader.common.repository.BaseRepository;
import com.digitalplay.network.ireader.common.repository.BatchRepository;

public interface CategoryRepository extends BaseRepository<Category, Long>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Category> findByNameOrderByIdAsc(String name,Pageable page);
	
}
