package com.digitalplay.network.ireader.service;

import java.util.ArrayList;
import java.util.Collection;

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
	public void  bulkAdd(){
		Category c= categoryService.findOne(1L);
		Collection<Category> entities = copyCategory(c);
		categoryService.bulkAdd(entities);
		categoryService.printStatics();
		c=categoryService.findOne(1L);
	}
	
		
	private Collection<Category> copyCategory(Category c){
		Collection<Category> categories = new ArrayList<Category>(1000);
		for (int i =0 ; i<1000;i++){
			Category aCat= new Category();
			aCat.setName(c.getName());
			aCat.setStatus(c.getStatus());
			categories.add(aCat);
		}
		return categories;
	}
}
