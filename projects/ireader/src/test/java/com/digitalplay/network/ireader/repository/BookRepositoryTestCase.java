package com.digitalplay.network.ireader.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;

import com.digitalplay.network.ireader.domain.Author;
import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.domain.Category;
import com.digitalplay.network.ireader.domain.Tag;
import com.digitalplay.network.ireader.test.spring.SpringTransactionalTestCase;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BookRepositoryTestCase extends SpringTransactionalTestCase {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void findTasksByUserId() throws Exception {
		Book book = bookRepository.findOne(1L);
	}
}
