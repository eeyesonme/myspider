package com.digitalplay.network.ireader.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(defaultRollback=false)
public class CategoryRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private CategoryRepository categoryDao;
	
	@Test
	public void testCreate(){
		Category category= new Category();
		category.setName("东方玄幻");
		category.setStatus("基于东方文化背景，描写主角修炼、冒险的幻想作品");
		categoryDao.save(category);
	}
}
