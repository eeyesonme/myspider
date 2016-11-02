
package com.digitalplay.network.ireader.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.digitalplay.network.ireader.common.search.SearchRequest;


@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID>,JpaSpecificationExecutor<M> {

	public void delete(final ID[] ids);
	
	public List<M> findAll();
	
	public List<M> findAll(Sort sort);
	
	public Page<M> findAll(Pageable pageable);
	
	public List<M> findAll(SearchRequest searchRequest);
	
    public Page<M> findAll(SearchRequest searchRequest ,Pageable pageable);

    public long count(SearchRequest searchRequest);

}
