package com.digitalplay.network.ireader.repository.book;


import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.digitalplay.network.ireader.domain.book.Book;
import com.digitalplay.network.ireader.repository.BaseRepository;

public interface BookRepository extends BaseRepository<Book,Long>{

	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public List<Book> findByCategoryNameOrderByIdDesc(String name,Pageable page);
	
	@Query("SELECT COUNT(*) FROM Book b WHERE b.category.id=?1")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public long countByCategoryId(Long categoryId);
}
