package com.digitalplay.network.ireader.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	private String isbn;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Tag> tags;
	

	
	public Book() {
	}

	public Book(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
