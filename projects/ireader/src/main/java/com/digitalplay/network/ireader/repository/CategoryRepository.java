package com.digitalplay.network.ireader.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> ,BatchRepository<Category>{

	public List<Category> findByName(String name);
}
