package com.digitalplay.network.ireader.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="ee_account_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccountRole {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="account_id" ,nullable=false, updatable=false)
	private Account account;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="role_id" ,nullable=false, updatable=false)
	private Role role;
	
	
}
