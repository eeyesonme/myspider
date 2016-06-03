package com.digitalplay.network.ireader.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.digitalplay.network.ireader.domain.Category;
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CategoryServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void  addCategory(){
		Category c= new Category();
		c.setName("sadfs");
		c.setStatus("基于东方文化背景，描写主角修炼、冒险的幻想作品");
		c.setId(1L);
		categoryService.AddCategory(c);
	}
}
