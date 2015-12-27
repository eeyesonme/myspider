package com.digitalplay.network.ireader.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ee_book")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	@JsonBackReference
	private Author author;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="book")
	@Fetch(FetchMode.SUBSELECT)
	private List<BookContent> bookContents =new ArrayList<BookContent>();
	
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="ee_book_tag",joinColumns =@JoinColumn(name="book_id" ,referencedColumnName="id" ),
	inverseJoinColumns =@JoinColumn (name="tag_id" ,referencedColumnName="id" )
)
	private List<Tag> bookTags;
	*/
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<BookContent> getBookContents() {
		return bookContents;
	}

	public void setBookContents(List<BookContent> bookContents) {
		this.bookContents = bookContents;
	}

	/*
	public List<Tag> getBookTags() {
		return bookTags;
	}

	public void setBookTags(List<Tag> bookTags) {
		this.bookTags = bookTags;
	}*/
	
	
}
