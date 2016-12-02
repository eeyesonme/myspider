package com.digitalplay.network.ireader.web;

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

import com.digitalplay.network.ireader.common.search.SearchRequest;
import com.digitalplay.network.ireader.domain.sys.Organization;
import com.digitalplay.network.ireader.domain.sys.Position;
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
        
        Pageable pageable = new PageRequest(1, 10, new Sort(Direction.ASC));
        
        Page<User> users =userService.findAll(searchRequest,  pageable);
        model.addAttribute("page",users);
        return "admin/sys/user/list";
    }
}
