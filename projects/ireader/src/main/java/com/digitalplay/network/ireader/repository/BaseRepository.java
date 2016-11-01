
package com.digitalplay.network.ireader.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.digitalplay.network.ireader.common.search.SearchRequest;


@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID>,JpaSpecificationExecutor<M> {

	public void delete(final ID[] ids);
	
    public Page<M> findAll(SearchRequest searchRequest);

    public long count(SearchRequest searchRequest);

}
