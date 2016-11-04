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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.common.search.SearchRequest;

@Transactional(readOnly = true)
public class SimpleBaseRepository<M, ID extends Serializable> extends SimpleJpaRepository<M, ID>
        implements BaseRepository<M, ID> {

	private Class<M> entityClass;
	
	private CrudMethodMetadata metadata;
	
    public SimpleBaseRepository(JpaEntityInformation<M, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityClass = entityInformation.getJavaType();
    }

    public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
		this.metadata = crudMethodMetadata;
		super.setRepositoryMethodMetadata(metadata);
	}

	protected CrudMethodMetadata getRepositoryMethodMetadata() {
		return metadata;
	}

    public Page<M> findAll(final SearchRequest searchRequest ,Pageable pageable) {
        return  findAll(searchRequest.toSpecification(this.entityClass),pageable);
    }

	public List<M> findAll(SearchRequest searchRequest) {
		return  findAll(searchRequest.toSpecification(this.entityClass));
	}
    
	public List<M> findAll(SearchRequest searchRequest, Sort sort) {
    	return  findAll(searchRequest.toSpecification(this.entityClass),sort);
	}
    
	@Override
	public void delete(ID[] ids) {
		
	}



	@Override
	public long count(SearchRequest searchRequest) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public M findOne(ID id) {
        if (id == null) {
            return null;
        }
        if (id instanceof Integer && ((Integer) id).intValue() == 0) {
            return null;
        }
        if (id instanceof Long && ((Long) id).longValue() == 0L) {
            return null;
        }
        return super.findOne(id);
    }
	


	




	


}
