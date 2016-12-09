package com.digitalplay.network.ireader.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.service.UserStatusHistoryService;
import com.digitalplay.network.ireader.util.Constants;


/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


	@Autowired
    private MessageSource messageSource;
    
    @Autowired
    private UserStatusHistoryService userStatusHistoryService;
    
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "front/login";
	}

	
	@RequestMapping(method = RequestMethod.POST)
    public String fail(HttpServletRequest request, Model model) {

        if (!StringUtils.isEmpty(request.getParameter("logout"))) {
            model.addAttribute(Constants.MESSAGE, messageSource.getMessage("user.logout.success", null, null));
        }

        if (!StringUtils.isEmpty(request.getParameter("notfound"))) {
            model.addAttribute(Constants.ERROR, messageSource.getMessage("user.notfound", null, null));
        }

        if (!StringUtils.isEmpty(request.getParameter("forcelogout"))) {
            model.addAttribute(Constants.ERROR, messageSource.getMessage("user.forcelogout", null, null));
        }

        if (!StringUtils.isEmpty(request.getAttribute("jcaptchaError"))) {
            model.addAttribute(Constants.ERROR, messageSource.getMessage("jcaptcha.validate.error", null, null));
        }


        if (!StringUtils.isEmpty(request.getParameter("blocked"))) {
        	User user = (User) request.getAttribute(Constants.CURRENT_USER);
            String reason = userStatusHistoryService.getLastReason(user);
            model.addAttribute(Constants.ERROR, messageSource.getMessage("user.blocked", new Object[]{reason}, null));
        }

        if (!StringUtils.isEmpty(request.getParameter("unknown"))) {
            model.addAttribute(Constants.ERROR, messageSource.getMessage("user.unknown.error", null, null));
        }

        Exception shiroLoginFailureEx =
                (Exception) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (shiroLoginFailureEx != null) {
            model.addAttribute(Constants.ERROR, shiroLoginFailureEx.getMessage());
        }

        Subject subject = SecurityUtils.getSubject();
        if (subject != null && subject.isAuthenticated()) {
            subject.logout();
        }


        if (model.containsAttribute(Constants.ERROR)) {
            model.asMap().remove(Constants.MESSAGE);
        }

        return "front/login";
    }
}
