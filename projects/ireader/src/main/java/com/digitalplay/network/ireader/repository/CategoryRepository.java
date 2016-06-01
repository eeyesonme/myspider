package com.digitalplay.network.ireader.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
