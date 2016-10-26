package com.digitalplay.network.ireader.service.book;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalplay.network.ireader.domain.book.Category;
import com.digitalplay.network.ireader.repository.book.CategoryRepository;
import com.digitalplay.network.ireader.util.HibernateUtils;

@Service
public class CategoryService {

	@Autowired 
	private CategoryRepository categoryDao;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void bulkAdd(Collection<Category> entities){
		//HibernateUtils.setCacheMode(em,CacheMode.IGNORE);
		categoryDao.batchInsert(entities);
	}
	
	public void printStatics(){
		HibernateUtils.printStatics(em);
	}
	
	@Transactional
	public Category findOne(Long id){
		return categoryDao.findOne(id);
	}
	
	
	@Transactional
	public Iterable<Category> listAll(){
		return categoryDao.findAll();
	}
}
