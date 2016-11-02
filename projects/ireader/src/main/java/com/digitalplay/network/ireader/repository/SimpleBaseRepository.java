/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.digitalplay.network.ireader.common.search.SearchRequest;

public class SimpleBaseRepository<M, ID extends Serializable> extends SimpleJpaRepository<M, ID>
        implements BaseRepository<M, ID> {

	private Class<M> entityClass;
	
    public SimpleBaseRepository(JpaEntityInformation<M, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityClass = entityInformation.getJavaType();
    }


    @Override
    public Page<M> findAll(final SearchRequest searchRequest ,Pageable pageable) {
        return  findAll(searchRequest.toSpecification(this.entityClass),pageable);
    }

    @Override
	public List<M> findAll(SearchRequest searchRequest) {
		return  findAll(searchRequest.toSpecification(this.entityClass));
	}
    
	@Override
	public void delete(ID[] ids) {
		
	}



	@Override
	public long count(SearchRequest searchRequest) {
		// TODO Auto-generated method stub
		return 0;
	}


	




	


}
