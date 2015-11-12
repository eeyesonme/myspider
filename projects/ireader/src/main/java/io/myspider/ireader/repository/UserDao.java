package io.myspider.ireader.repository;

import io.myspider.ireader.entity.User;

public interface UserDao  {
	User findByLoginName(String loginName);
}
