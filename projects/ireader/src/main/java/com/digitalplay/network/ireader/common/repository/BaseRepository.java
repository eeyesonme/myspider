
package com.digitalplay.network.ireader.common.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.NoRepositoryBean;

import com.digitalplay.network.ireader.common.search.SearchRequest;


@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends JpaRepository<M, ID>,JpaSpecificationExecutor<M> {

	public void delete(final ID[] ids);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<M> findAll();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<M> findAll(Sort sort);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Page<M> findAll(Pageable pageable);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<M> findAll(SearchRequest searchRequest);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<M> findAll(SearchRequest searchRequest ,Sort sort);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    public Page<M> findAll(SearchRequest searchRequest ,Pageable pageable);

    public long count(SearchRequest searchRequest);

}
