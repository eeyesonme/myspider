package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
@Table(name="ee_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String permissions;
	
	@OneToMany(mappedBy="role")
	@Fetch(FetchMode.SUBSELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<AccountRole> account_roles = new ArrayList();
	
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

	public List<AccountRole> getAccount_roles() {
		return account_roles;
	}

	public void setAccount_roles(List<AccountRole> account_roles) {
		this.account_roles = account_roles;
	}
	
	

}
