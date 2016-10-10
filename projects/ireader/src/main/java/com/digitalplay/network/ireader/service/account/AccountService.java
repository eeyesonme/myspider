package com.digitalplay.network.ireader.service.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Account;
import com.digitalplay.network.ireader.repository.AccountRepository;
import com.digitalplay.network.ireader.util.Clock;
import com.digitalplay.network.ireader.util.Digests;
import com.digitalplay.network.ireader.util.Encodes;

@Service
public class AccountService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	private Clock clock = Clock.DEFAULT;

	@Autowired 
	private AccountRepository accountDao;
	
	
	@Transactional(readOnly = true)
	public Iterable<Account> findAll(Pageable pageable) {
		return accountDao.findAll(pageable);
	}
	
	public Account findOne(Long id){
		return accountDao.findOne(id);
	}
	
	public Account findAccountByLoginName(String loginName){
		return null;
	}
	
	public void registerAccount(Account account){
		entryptPassword(account);
		account.setRegisterDate(clock.getCurrentDate());
		accountDao.save(account);
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(Account account) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		account.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(account.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		account.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	
}
