package com.digitalplay.network.ireader.web;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.transaction.Transactional;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalplay.network.ireader.domain.Book;
import com.digitalplay.network.ireader.service.BookService;
import com.digitalplay.network.ireader.util.Servlets;
import com.google.common.collect.Maps;

//@RestController
@Controller
@Transactional
public class BookEndPoint {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private Validator validator;
	
	private static final String PAGE_SIZE = "50";
	
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("name", "标题");
	}
	
	@RequestMapping(value = "/book",method = RequestMethod.GET)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Page<Book> books =bookService.listBooks( searchParams, pageNumber, pageSize, sortType);
		model.addAttribute("books", books);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "book/bookList";
	}
	
	
	
	@RequestMapping(value="/book/{id}" ,method = RequestMethod.GET)
	public String getBookDetail(@PathVariable("id") Long id,Model model){
		Book book= bookService.findOne(id);
		model.addAttribute("book",book);
		return "book/bookDetail";
	}

	/*@RequestMapping(value="/api/book/{id}" ,method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Book getBook(@PathVariable("id") Long id){
		Book book= bookService.findOne(id);
		return book;
	}
	
	@RequestMapping(value="/api/books" ,produces = MediaTypes.JSON_UTF_8)
	public List<Book> list(Pageable pageable){
		Iterable<Book> book= bookService.findAll(pageable);
		ArrayList<Book> books= new ArrayList<Book>();
		Iterator<Book> iter= book.iterator();
		while(iter.hasNext()){
			books.add(iter.next());
		}
		return books;
	}
	*/
}
