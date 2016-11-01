
package com.digitalplay.network.ireader.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.digitalplay.network.ireader.search.Searchable;


@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends PagingAndSortingRepository<M, ID>,JpaSpecificationExecutor<M> {

	public void delete(final ID[] ids);
	
    public Page<M> findAll(Searchable searchable);

    public long count(Searchable searchable);

}
