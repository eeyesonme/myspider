package com.digitalplay.network.ireader.repository;

import java.util.Collection;
import java.util.List;
public interface BatchRepository<T> {
	 List<T> batchInsert(Collection<T> entities);
	 List<T> batchUpdate(Collection<T> entities);
}
