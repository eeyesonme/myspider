package com.digitalplay.network.ireader.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<M, ID extends Serializable> extends PagingAndSortingRepository<M, ID> {

    public void delete(ID[] ids);

    public boolean support(String modelType);


}
