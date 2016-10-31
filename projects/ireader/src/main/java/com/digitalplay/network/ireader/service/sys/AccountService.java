package com.digitalplay.network.ireader.service.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digitalplay.network.ireader.domain.sys.User;
import com.digitalplay.network.ireader.domain.sys.UserBlockedException;
import com.digitalplay.network.ireader.domain.sys.UserNotExistsException;
import com.digitalplay.network.ireader.domain.sys.UserPasswordNotMatchException;
import com.digitalplay.network.ireader.domain.sys.UserStatus;
import com.digitalplay.network.ireader.repository.sys.AccountRepository;
import com.digitalplay.network.ireader.service.BaseService;
import com.digitalplay.network.ireader.util.Clock;
import com.digitalplay.network.ireader.util.Digests;
import com.digitalplay.network.ireader.util.Encodes;

@Service
public class AccountService extends BaseService<User, Long>{
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	private Clock clock = Clock.DEFAULT;

	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private UserStatusHistoryService userStatusHistoryService;
	
	@Autowired
	private AccountRepository getUserRepository() {
		return (AccountRepository) baseRepository;
	}
	
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return getUserRepository().findAll(pageable);
	}
	
	public User findOne(Long id){
		return getUserRepository().findOne(id);
	}
	
	public User findAccountByUsername(String username){
		return getUserRepository().findByUsername(username);
	}
	
	public void registerAccount(User account){
		entryptPassword(account);
		account.setCreateDate(clock.getCurrentDate());
		getUserRepository().save(account);
	}
	
	public User findByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return null;
		}
		return getUserRepository().findByUsername(username);
	}

	public User findByEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		return getUserRepository().findByEmail(email);
	}

	public User findByMobile(String mobilePhoneNumber) {
		if (StringUtils.isEmpty(mobilePhoneNumber)) {
			return null;
		}
		return getUserRepository().findByMobile(mobilePhoneNumber);
	}
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User account) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		account.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(account.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		account.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	public User login(String username, String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new UserNotExistsException();
        }
        //密码如果不在指定范围内 肯定错误
        if (password.length() < User.PASSWORD_MIN_LENGTH || password.length() > User.PASSWORD_MAX_LENGTH) {
            throw new UserPasswordNotMatchException();
        }

        User user = null;

        if (maybeUsername(username)) {
            user = findByUsername(username);
        }

        if (user == null && maybeEmail(username)) {
            user = findByEmail(username);
        }

        if (user == null && maybeMobile(username)) {
            user = findByMobile(username);
        }

        if (user == null || Boolean.TRUE.equals(user.getDeleted())) {

            throw new UserNotExistsException();
        }

        passwordService.validate(user, password);

        if (user.getStatus() == UserStatus.blocked) {
            throw new UserBlockedException(userStatusHistoryService.getLastReason(user));
        }

        return user;
    }

	private boolean maybeUsername(String username) {
        if (!username.matches(User.USERNAME_PATTERN)) {
            return false;
        }
        //如果用户名不在指定范围内也是错误的
        if (username.length() < User.USERNAME_MIN_LENGTH || username.length() > User.USERNAME_MAX_LENGTH) {
            return false;
        }

        return true;
    }

    private boolean maybeEmail(String username) {
        if (!username.matches(User.EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    private boolean maybeMobile(String username) {
        if (!username.matches(User.MOBILE_PHONE_NUMBER_PATTERN)) {
            return false;
        }
        return true;
    }
}
