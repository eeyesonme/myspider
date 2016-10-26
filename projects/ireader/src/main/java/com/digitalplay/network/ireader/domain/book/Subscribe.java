package com.digitalplay.network.ireader.domain.book;

import java.util.Date;

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

import com.digitalplay.network.ireader.domain.sys.User;

@Entity
@Table(name="T_SUBSCRIBE")
@Cache(region="Subscribe",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Subscribe {

	@TableGenerator(name = "subscribe_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="SUBSCRIBE_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="subscribe_gen") 
	private Long id;
	
	private Date subscribe_time;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id" ,nullable=false, updatable=false)
	private User account;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="book_id" ,nullable=false, updatable=false)
	private Book book;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAccount() {
		return account;
	}

	public void setAccount(User account) {
		this.account = account;
	}
	
	
}
