package com.digitalplay.network.ireader.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractBatchRepository<T> implements BatchRepository<T> {

	@PersistenceContext
    protected EntityManager em;
	
	private int batchSize =50;

	@Override
	public  void batchInsert(Collection<T> entities) {
		  int i = 0;
		  for (T t : entities) {
			 em.persist(t);
		    i++;
		   if (i % batchSize == 0) {
		      em.flush();
		      em.clear();
		   }
		  }
	}

	
	@Override
	public void batchUpdate(Collection<T> entities) {
	}
	
}
	
