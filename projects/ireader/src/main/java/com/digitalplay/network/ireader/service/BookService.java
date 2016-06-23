package com.digitalplay.network.ireader.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.repository.BookRepository;
import com.digitalplay.network.ireader.util.DynamicSpecifications;
import com.digitalplay.network.ireader.util.SearchFilter;

@Service
public class BookService {

	@Autowired
	private BookRepository bookDao;


	@Transactional(readOnly = true)
	public Iterable<Book> findAll(Pageable pageable) {
		return bookDao.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}

	public Page<Book> getAuthorBooks( Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Book> spec = buildSpecification( searchParams);

		return bookDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Book> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Book> spec = DynamicSpecifications.bySearchFilter(filters.values(), Book.class);
		return spec;
	}
}
