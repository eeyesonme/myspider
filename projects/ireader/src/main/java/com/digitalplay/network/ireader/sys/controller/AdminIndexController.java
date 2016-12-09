package com.digitalplay.network.ireader.sys.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitalplay.network.ireader.common.annotation.CurrentUser;
import com.digitalplay.network.ireader.sys.domain.Menu;
import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.service.ResourceService;

@Controller
@Transactional
@RequestMapping("/admin")
public class AdminIndexController {

	 @Autowired
	    private ResourceService resourceService;
	 
	 @RequestMapping(value = "/index") 
	    public String index(@CurrentUser User user, Model model) {

	        List<Menu> menus = resourceService.findMenus(user);
	        model.addAttribute("menus", menus);
	        return "admin/index/index";
	    }
	 
	 @RequestMapping(value = "/welcome")
	    public String welcome(@CurrentUser User loginUser, Model model) {

	        //未读消息
	        Long messageUnreadCount = 5L;
	        model.addAttribute("messageUnreadCount", messageUnreadCount);

	        return "admin/index/welcome";
	    }
}
