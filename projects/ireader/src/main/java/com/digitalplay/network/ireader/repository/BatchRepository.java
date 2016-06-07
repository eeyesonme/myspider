package com.digitalplay.network.ireader.repository;

import java.util.Collection;

import javax.transaction.Transactional;

public interface BatchRepository<T> {
	@Transactional
	 void batchInsert(Collection<T> entities);
	 void batchUpdate(Collection<T> entities);
}
