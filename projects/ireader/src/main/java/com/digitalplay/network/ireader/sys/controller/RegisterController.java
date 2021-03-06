package com.digitalplay.network.ireader.sys.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.service.UserService;

/**
 * 用户注册的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private UserService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		return "account/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid User account, RedirectAttributes redirectAttributes) {
		accountService.registerAccount(account);
		redirectAttributes.addFlashAttribute("username", account.getUsername());
		return "redirect:/login";
	}

	/**
	 * Ajax请求校验loginName是否唯一。
	 */
	@RequestMapping(value = "checkUsername")
	@ResponseBody
	public String checkLoginName(@RequestParam("username") String username) {
		if (accountService.findAccountByUsername(username) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}
