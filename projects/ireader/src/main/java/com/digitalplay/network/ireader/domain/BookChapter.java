package com.digitalplay.network.ireader.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ee_book_chapter")
public class BookChapter {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String content;
	
	@Column(name="update_time")
	private Date update_time;
	
	@ManyToOne
	@JoinColumn(name="book_id" ,nullable=false, updatable=false)
	private Book book;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdatetime() {
		return update_time;
	}

	public void setUpdatetime(Date updatetime) {
		this.update_time = updatetime;
	}
	
	
}
