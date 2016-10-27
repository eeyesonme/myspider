package com.digitalplay.network.ireader.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalplay.network.ireader.domain.book.Book;
import com.digitalplay.network.ireader.domain.book.Category;
import com.digitalplay.network.ireader.service.book.BookService;
import com.digitalplay.network.ireader.service.book.CategoryService;
import com.digitalplay.network.ireader.util.Servlets;
import com.google.common.collect.Maps;

@Controller
@Transactional
public class IndexController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	private static final String PAGE_SIZE = "10";
	
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("name", "标题");
	}
	
	/*@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Page<Book> books =bookService.listBooks( searchParams, pageNumber, pageSize, sortType);
		Iterable<Category> categories =categoryService.listAll();
		Collection<Category> cates = new ArrayList<Category>();
		for(Category c : categories){
			c.setBookCount(bookService.countBookByCategoryId(c.getId()));
			cates.add(c);
		}
		model.addAttribute("categories",cates);
		model.addAttribute("books", books);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "index";
	}*/
	
	
}
