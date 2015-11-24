package com.digitalplay.network.ireader.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ee_book_subscribe")
public class BookSubscribe {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Account account;
	
	private Date subscribe_time;

	public Date getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	
	
}
