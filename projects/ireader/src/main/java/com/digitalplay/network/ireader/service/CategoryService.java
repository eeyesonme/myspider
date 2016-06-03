package com.digitalplay.network.ireader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired 
	private CategoryRepository categoryDao;
	
	@Transactional
	public void  AddCategory(Category c){
		categoryDao.save(c);
	}
	
}
