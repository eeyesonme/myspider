package com.digitalplay.network.ireader.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitalplay.network.ireader.domain.sys.Menu;
import com.digitalplay.network.ireader.domain.sys.User;
import com.digitalplay.network.ireader.service.sys.ResourceService;
import com.digitalplay.network.ireader.web.annotation.CurrentUser;

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
}
