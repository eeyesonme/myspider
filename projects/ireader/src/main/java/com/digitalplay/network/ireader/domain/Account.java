package com.digitalplay.network.ireader.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ee_account")
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
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="account")
	private List<AccountSubscribe> subscribes;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="ee_account_role",joinColumns =@JoinColumn(name="account_id" ,referencedColumnName="id" ),
			inverseJoinColumns =@JoinColumn (name="role_id" ,referencedColumnName="id" )
	)
	private List<Role> roles;
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> hits;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> stars;*/
	
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

	public List<AccountSubscribe> getSubscribes() {
		return subscribes;
	}

	public void setSubscribes(List<AccountSubscribe> subscribes) {
		this.subscribes = subscribes;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
