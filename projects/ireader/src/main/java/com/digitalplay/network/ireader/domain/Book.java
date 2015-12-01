package com.digitalplay.network.ireader.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private String name;

	@Column(nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id" ,nullable=false, updatable=false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="author_id" ,nullable=false, updatable=false)
	private Author author;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="book")
	private List<BookChapter> chapters;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="ee_book_tag",joinColumns =@JoinColumn(name="book_id" ,referencedColumnName="id" ),
	inverseJoinColumns =@JoinColumn (name="tag_id" ,referencedColumnName="id" )
)
	private List<Tag> bookTags;
	
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

	public List<BookChapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<BookChapter> chapters) {
		this.chapters = chapters;
	}

	public List<Tag> getBookTags() {
		return bookTags;
	}

	public void setBookTags(List<Tag> bookTags) {
		this.bookTags = bookTags;
	}
	
	
}
