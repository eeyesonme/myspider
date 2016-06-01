package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="T_CATEGORY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {

	@TableGenerator(name = "category_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="CATEGORY_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="category_gen") 
	private Long id;
	
	private String name;
	
	private String status;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="category")
	@Fetch(FetchMode.SUBSELECT)
	private Collection<Book> books =new ArrayList<Book> ();
	
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

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
	
	
}
