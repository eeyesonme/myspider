package com.digitalplay.network.ireader.repository.sys;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.digitalplay.network.ireader.domain.sys.User;
import com.digitalplay.network.ireader.domain.sys.UserOrganizationPosition;
import com.digitalplay.network.ireader.repository.BaseRepository;


public interface AccountRepository extends BaseRepository<User,Long> {

	public User findByMobile(String mobile);
	
	public User findByEmail(String email);
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public User findByUsername(String username);
	
    @Query("from UserOrganizationPosition where user=?1 and organizationId=?2 and positionId=?3")
    UserOrganizationPosition findUserOrganization(User user, Long organizationId, Long positionId);
}
