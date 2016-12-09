package com.digitalplay.network.ireader.book.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T_BOOK")
@DynamicUpdate
//@Cache(region="Book",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book {

	@TableGenerator(name = "book_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="BOOK_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="book_gen") 
	private Long id;
	private String name;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	@JsonBackReference
	private Author author;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="book",cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonManagedReference
	private List<BookContent> bookContents =new ArrayList<BookContent>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "T_TAG", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id ASC")
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Tag> bookTags = new ArrayList<Tag>();
	
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

	public void addContent(BookContent bc){
		this.bookContents.add(bc);
		bc.setBook(this);
	}
	
	public void removeContent(BookContent bc){
		bc.setBook(null);
		this.bookContents.remove(bc);
	}
	
	public List<Tag> getBookTags() {
		return bookTags;
	}

	public void setBookTags(List<Tag> bookTags) {
		this.bookTags = bookTags;
	}

}
