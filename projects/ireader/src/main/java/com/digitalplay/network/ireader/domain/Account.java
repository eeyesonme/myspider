package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="ee_account")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String email;
	
	private String mobile;
	
	private String password;
	
	private String salt;
	
	private String status;
	
	private Date regist_date;
	
	/*@OneToMany(fetch = FetchType.LAZY,mappedBy="account")
	private List<AccountSubscribe> subscribes;*/
	
	@OneToMany(mappedBy="account")
	@Fetch(FetchMode.SUBSELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<AccountRole> account_roles = new ArrayList();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() { 
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

	/*public List<AccountSubscribe> getSubscribes() {
		return subscribes;
	}

	public void setSubscribes(List<AccountSubscribe> subscribes) {
		this.subscribes = subscribes;
	}*/

	public List<AccountRole> getAccountRoles() {
		return account_roles;
	}

	public void setAccountRoles(List<AccountRole> account_roles) {
		this.account_roles = account_roles;
	}
	
	
	
	
}
