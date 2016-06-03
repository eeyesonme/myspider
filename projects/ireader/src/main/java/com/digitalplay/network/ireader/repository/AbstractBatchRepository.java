package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.CacheMode;

import com.digitalplay.network.ireader.util.HibernateUtils;

public abstract class AbstractBatchRepository<T> implements BatchRepository<T> {

	@PersistenceContext
    protected EntityManager em;
	
	private int batchSize =50;

	@Override
	public  List<T> batchInsert(Collection<T> entities) {
		CacheMode oldMode = HibernateUtils.getSession(em).getCacheMode();
		HibernateUtils.getSession(em).setCacheMode(CacheMode.IGNORE);
		final List<T> savedEntities = new ArrayList<T>(entities.size());
		  int i = 0;
		  for (T t : entities) {
			 em.persist(t);
		    savedEntities.add(t);
		    i++;
		    //if (i % batchSize == 0) {
		      em.flush();
		      em.clear();
//		    }
		  }
		  HibernateUtils.getSession(em).setCacheMode(oldMode);		  
		  return savedEntities;
	}

	
	@Override
	public List<T> batchUpdate(Collection<T> entities) {
		return null;
	}
	
}
	
