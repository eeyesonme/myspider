package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="ee_category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String status;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="category")
	@Fetch(FetchMode.SUBSELECT)
	private List<Book> books =new ArrayList<Book> ();
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
