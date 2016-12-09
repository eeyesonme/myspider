package com.digitalplay.network.ireader.common.repository;

import java.util.Collection;

import javax.transaction.Transactional;

public interface BatchRepository<T> {
	@Transactional
	 void batchInsert(Collection<T> entities);
	 void batchUpdate(Collection<T> entities);
}
