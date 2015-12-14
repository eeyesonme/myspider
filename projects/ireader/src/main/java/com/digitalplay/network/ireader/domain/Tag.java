package com.digitalplay.network.ireader.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="ee_tag")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	/*@ManyToMany(fetch = FetchType.LAZY,mappedBy="bookTags")
	private List<Book>  books;*/
	
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

}
