/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.sys.repository;

import org.springframework.data.jpa.repository.Query;

import com.digitalplay.network.ireader.common.repository.BaseRepository;
import com.digitalplay.network.ireader.sys.domain.Role;
import com.digitalplay.network.ireader.sys.domain.RoleResourcePermission;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-2-4 下午3:00
 * <p>Version: 1.0
 */
public interface RoleRepository extends BaseRepository<Role, Long> {

    @Query("from RoleResourcePermission where role=?1 and resourceId=?2")
    RoleResourcePermission findRoleResourcePermission(Role role, Long resourceId);
}
