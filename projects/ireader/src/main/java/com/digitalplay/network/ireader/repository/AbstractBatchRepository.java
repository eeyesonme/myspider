package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractBatchRepository<T> implements BatchRepository<T> {

	@PersistenceContext
    protected EntityManager em;
	
	private int batchSize =50;

	@Override
	public  List<T> batchInsert(Collection<T> entities) {
		final List<T> savedEntities = new ArrayList<T>(entities.size());
		  int i = 0;
		  for (T t : entities) {
			 em.persist(t);
		    savedEntities.add(t);
		    i++;
		    if (i % batchSize == 0) {
		      em.flush();
		      em.clear();
		    }
		  }
		  return savedEntities;
	}

	@Override
	public List<T> batchUpdate(Collection<T> entities) {
		return null;
	}
}
	
