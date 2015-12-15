package com.digitalplay.network.ireader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired 
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public Iterable<Author> findAll(Pageable pageable) {
		return authorRepository.findAll(pageable);
	}
	
	public Author findOne(Long id){
		return authorRepository.findOne(id);
	}
}
