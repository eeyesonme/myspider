package com.digitalplay.network.ireader.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ee_book")
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="book")
	private List<BookChapter> chapters;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="book")
	private List<BookSubscribe> subscribes;
	
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
