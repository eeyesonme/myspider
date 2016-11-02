/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.service.sys;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.digitalplay.network.ireader.common.search.SearchRequest;
import com.digitalplay.network.ireader.domain.sys.User;
import com.digitalplay.network.ireader.domain.sys.UserStatus;
import com.digitalplay.network.ireader.domain.sys.UserStatusHistory;
import com.digitalplay.network.ireader.service.BaseService;

@Service
public class UserStatusHistoryService extends BaseService<UserStatusHistory, Long> {

    public void log(User opUser, User user, UserStatus newStatus, String reason) {
        UserStatusHistory history = new UserStatusHistory();
        history.setUser(user);
        history.setOpUser(opUser);
        history.setOpDate(new Date());
        history.setStatus(newStatus);
        history.setReason(reason);
        save(history);
    }

    public UserStatusHistory findLastHistory(final User user) {
        SearchRequest searchable = new SearchRequest();
        		searchable .addSearchParam("user_eq", user);
        		searchable.addSort(Sort.Direction.DESC, "opDate");
        		searchable.setPage(0, 1);

        Page<UserStatusHistory> page = baseRepository.findAll(searchable,searchable.getPage());

        if (page.hasContent()) {
            return page.getContent().get(0);
        }
        return null;
    }

    public String getLastReason(User user) {
        UserStatusHistory history = findLastHistory(user);
        if (history == null) {
            return "";
        }
        return history.getReason();
    }
}
