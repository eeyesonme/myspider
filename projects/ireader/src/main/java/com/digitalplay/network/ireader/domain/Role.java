package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ee_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String permissions;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="role",cascade = CascadeType.ALL, orphanRemoval = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonManagedReference
	private List<AccountRole> accounts = new ArrayList<AccountRole>();
	
	public List<AccountRole> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountRole> accounts) {
		this.accounts = accounts;
	}
	
	public void AddAccount(AccountRole account){
		this.accounts.add(account);
		account.setRole(this);
	}

	public void removeAccount(AccountRole account){
		account.setRole(null);
		accounts.remove(account);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	
}
