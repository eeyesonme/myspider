package com.digitalplay.network.ireader.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ee_book_subscribe")
public class AccountSubscribe {

	@Id
	@GeneratedValue
	private long id;
	
	private Date subscribe_time;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="account_id" ,nullable=false, updatable=false)
	private Account account;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="book_id" ,nullable=false, updatable=false)
	private Book book;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getSubscribe_time() {
		return subscribe_time;
	}
	
	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
