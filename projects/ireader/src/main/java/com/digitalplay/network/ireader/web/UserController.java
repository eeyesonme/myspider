package com.digitalplay.network.ireader.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitalplay.network.ireader.domain.sys.User;
import com.digitalplay.network.ireader.service.sys.AccountService;
import com.digitalplay.network.ireader.web.annotation.CurrentUser;

@Controller
@Transactional
@RequestMapping( "/admin/sys/user")
public class UserController {

	@Autowired
	private AccountService userService;
	
	@RequestMapping(value = "/main" ,method = RequestMethod.GET) 
	public String main(@CurrentUser User user, Model model){
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/sys/user/list";
	}
	
}
