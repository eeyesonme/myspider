/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.repository.sys;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;

import com.digitalplay.network.ireader.domain.sys.Resource;
import com.digitalplay.network.ireader.repository.BaseRepository;

public interface ResourceRepository extends BaseRepository<Resource, Long> {
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Resource> findByShowTrueOrderByParentId();
}
