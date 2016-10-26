package com.digitalplay.network.ireader.domain.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="T_BOOK_CONTENT")
@Cache(region="BookContent" ,usage = CacheConcurrencyStrategy.READ_WRITE)
public class BookContent {

	@TableGenerator(name = "bookcontent_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="BOOKCONTENT_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="bookcontent_gen") 
	private Long id;
		
	@Column(name="title")
	private String contentTitle;
	
	@Column(name="content")
	private String contentMain;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	@JsonBackReference
	private  Book book;
	
	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentMain() {
		return contentMain;
	}

	public void setContentMain(String contentMain) {
		this.contentMain = contentMain;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
	
}
