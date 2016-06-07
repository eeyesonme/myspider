package com.digitalplay.network.ireader.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.CacheMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.repository.CategoryRepository;
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
		CacheMode mode = HibernateUtils.getCacheMode(em);
		System.out.println("Cache Mode :: "+ mode.name());
		return categoryDao.findOne(id);
	}
	
	
	
}
