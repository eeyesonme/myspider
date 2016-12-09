package com.digitalplay.network.ireader.sys.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitalplay.network.ireader.common.annotation.CurrentUser;
import com.digitalplay.network.ireader.common.search.SearchRequest;
import com.digitalplay.network.ireader.sys.domain.Organization;
import com.digitalplay.network.ireader.sys.domain.Position;
import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.service.UserService;

@Controller
@Transactional
@RequestMapping( "/admin/sys/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/main" ,method = RequestMethod.GET) 
	public String main(@CurrentUser User user, Model model){
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/sys/user/main";
	}
	
	@RequestMapping(value = {"{organization}/{position}"}, method = RequestMethod.GET)
    public String list(@PathVariable("organization") Organization organization,
    		@PathVariable("position") Position position,
            SearchRequest searchRequest, Model model) {

        if (organization != null && !organization.isRoot()) {
        	searchRequest.addSearchParam("organizationId", organization.getId());
        }
        if (position != null && !position.isRoot()) {
        	searchRequest.addSearchParam("positionId", position.getId());
        }
        
        Pageable pageable = new PageRequest(0, 10, new Sort(Direction.DESC,"id"));
        
        Page<User> users =userService.findAll(searchRequest,  pageable);
        model.addAttribute("page",users);
        return "admin/sys/user/list";
    }
}
