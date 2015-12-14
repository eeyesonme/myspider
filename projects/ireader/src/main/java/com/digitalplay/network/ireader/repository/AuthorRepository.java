package com.digitalplay.network.ireader.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.domain.Author;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

}
