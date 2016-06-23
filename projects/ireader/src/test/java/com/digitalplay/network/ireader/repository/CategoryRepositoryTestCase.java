package com.digitalplay.network.ireader.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;
@ContextConfiguration(locations = { "/applicationContext.xml" })
@Rollback(false)
public class CategoryRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private CategoryRepository categoryDao;
	
	//@Test
	public void testCreate(){
		Category category= new Category();
		category.setName("东方玄幻");
		category.setStatus("基于东方文化背景，描写主角修炼、冒险的幻想作品");
		categoryDao.save(category);
	}
	
	//@Test
	public void testBatchCreate(){
		Category c= categoryDao.findOne(1L);
		Collection<Category> categories = copyCategory(c);
		categoryDao.batchInsert(categories);
	}
	
	@Test
	public void testQueryCache(){
		//Sort sort =new Sort(Direction.DESC, "id");
		PageRequest pr = new PageRequest(0,1000);

		List<Category> cates =categoryDao.findByNameOrderByIdDesc("东方玄幻",pr);
		System.out.println("----------------Find data first time------------------");
		for (Category c: cates){
			System.out.println(c.getId()+":"+c.getName());
		}
		System.out.println("----------------Find data Second time------------------");
		List<Category> cates2= categoryDao.findByNameOrderByIdDesc("东方玄幻",pr);
		for (Category c: cates2){
			System.out.println(c.getId()+":"+c.getName());
		}
	}
	
	private Collection<Category> copyCategory(Category c){
		Collection<Category> categories = new ArrayList<Category>(1);
		for (int i =0 ; i<1000;i++){
			Category aCat= new Category();
			aCat.setName(c.getName());
			aCat.setStatus(c.getStatus());
			categories.add(aCat);
		}
		return categories;
	}
	
	
	
}
