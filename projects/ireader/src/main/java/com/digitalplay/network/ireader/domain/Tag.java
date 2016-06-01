package com.digitalplay.network.ireader.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="T_TAG")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tag {

	@TableGenerator(name = "tag_gen" ,table="T_IDGENERATOR",pkColumnName="gen_name",valueColumnName="gen_value",pkColumnValue="TAG_PK",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tag_gen") 
	private Long id;
	
	@Column(name="name")
	private String tagName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


}
