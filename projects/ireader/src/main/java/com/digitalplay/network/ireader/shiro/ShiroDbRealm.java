/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.digitalplay.network.ireader.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.digitalplay.network.ireader.common.exception.UserBlockedException;
import com.digitalplay.network.ireader.common.exception.UserException;
import com.digitalplay.network.ireader.common.exception.UserNotExistsException;
import com.digitalplay.network.ireader.common.exception.UserPasswordNotMatchException;
import com.digitalplay.network.ireader.common.exception.UserPasswordRetryLimitExceedException;
import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.service.UserAuthService;
import com.digitalplay.network.ireader.sys.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	protected UserService userService;

	@Autowired
	private UserAuthService userAuthService;
	
	 @Autowired
	    public ShiroDbRealm(ApplicationContext ctx) {
	        super();
	    }

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) authcToken;
        String username = upToken.getUsername().trim();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }

        User user = null;
        try {
            user = userService.login(username, password);
        } catch (UserNotExistsException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        } catch (UserPasswordNotMatchException e) {
            throw new AuthenticationException(e.getMessage(), e);
        } catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        } catch (UserBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (Exception e) {
            throw new AuthenticationException(new UserException("user.unknown.error", null));
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), password.toCharArray(), getName());
        return info;
    }


	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		if (user != null){
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			authorizationInfo.setRoles(userAuthService.findStringRoles(user));
			authorizationInfo.setStringPermissions(userAuthService.findStringPermissions(user));

			return authorizationInfo;
		}
		return null;
	}


	public void setAccountService(UserService accountService) {
		this.userService = accountService;
	}

}
