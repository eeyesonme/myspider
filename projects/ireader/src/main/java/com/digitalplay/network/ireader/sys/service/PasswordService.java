/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.sys.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.digitalplay.network.ireader.common.exception.UserPasswordNotMatchException;
import com.digitalplay.network.ireader.common.exception.UserPasswordRetryLimitExceedException;
import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.util.Digests;
import com.digitalplay.network.ireader.util.Encodes;


@Service
public class PasswordService {

	public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    
    @Autowired
	private CacheManager cacheManager;

    private Cache<String, AtomicInteger> passwordRetryCache;

    @Value(value = "${user.password.maxRetryCount}")
    private int maxRetryCount = 3;

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    
    
    @PostConstruct
    public void init() {
    	passwordRetryCache = cacheManager.getCache("loginRecordCache");
    }

    public void validate(User user, String password) {
        String username = user.getUsername();

        AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > maxRetryCount) {
			 throw new UserPasswordRetryLimitExceedException(maxRetryCount);
		}

        boolean matches = matches(user, password);
		if (matches) {
			passwordRetryCache.remove(username);
		}else{
			throw new UserPasswordNotMatchException();
		}
    }

    public boolean matches(User user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }

    public void clearLoginRecordCache(String username) {
    	passwordRetryCache.remove(username);
    }
    
    public String encryptPassword(String username, String password, String salt) {
    	byte[] salts = Encodes.decodeHex(salt);
		byte[] hashPassword = Digests.sha1(password.getBytes(), salts, HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
    }

}
