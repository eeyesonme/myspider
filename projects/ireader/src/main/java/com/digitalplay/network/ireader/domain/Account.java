package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.ImmutableList;


@Entity
@Table(name="T_ACCOUNT")
@Cache(region="Account", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Account {

	@TableGenerator(name = "account_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="ACCOUNT_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="account_gen") 
	private Long id;
	
	private String username;
	
	private String email;
	
	private String mobile;
	
	private String password;
	

	// 不持久化到数据库，也不显示在Restful接口的属性.
	@Transient
	@JsonIgnore
	private String plainPassword;
	
	private String salt;
	
	private String status;
	
	@Column(name="REGIST_DATE")
	private Date registerDate;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="account",cascade = CascadeType.ALL, orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonManagedReference
	private List<AccountRole> roles = new ArrayList<AccountRole>();
	
	public List<AccountRole> getRoles() {
		return roles;
	}

	@Transient
	@JsonIgnore
	public List<String> getRoleList() {
		List<String> roleList = new ArrayList<String>(roles.size());
		for(AccountRole role : roles){
			roleList.add(role.getRole().getName());
		}
		return roleList;
	}
	
	public void setRoles(List<AccountRole> roles) {
		this.roles = roles;
	}

	public void addRole(AccountRole role){
		this.roles.add(role);
		role.setAccount(this);
	}
	
	public void removeRole(AccountRole role){
		role.setAccount(null);
		this.roles.remove(role);
	}
	
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
	
	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	
}
