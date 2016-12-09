package com.digitalplay.network.ireader.sys.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalplay.network.ireader.common.annotation.CurrentUser;
import com.digitalplay.network.ireader.common.search.SearchRequest;
import com.digitalplay.network.ireader.sys.domain.Organization;
import com.digitalplay.network.ireader.sys.domain.Position;
import com.digitalplay.network.ireader.sys.domain.User;
import com.digitalplay.network.ireader.sys.domain.UserOrganizationPosition;
import com.digitalplay.network.ireader.sys.service.UserService;

@Controller
@Transactional
@RequestMapping("/admin/sys/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(@CurrentUser User user, Model model) {

		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/sys/user/main";
	}

	@RequestMapping(value = { "{organization}/{position}" }, method = RequestMethod.GET)
	public String list(@PathVariable("organization") Organization organization,
			@PathVariable("position") Position position, SearchRequest searchRequest, Model model) {

		if (organization != null && !organization.isRoot()) {
			searchRequest.addSearchParam("organizationId", organization.getId());
		}
		if (position != null && !position.isRoot()) {
			searchRequest.addSearchParam("positionId", position.getId());
		}

		Pageable pageable = new PageRequest(0, 10, new Sort(Direction.DESC, "id"));

		Page<User> users = userService.findAll(searchRequest, pageable);
		model.addAttribute("page", users);
		return "admin/sys/user/list";
	}

	@RequestMapping(value = "create")
	public String createWithOrganization(Model model, @Valid @ModelAttribute("m") User m, BindingResult result,
			@RequestParam(value = "organizationId", required = false) Long[] organizationIds,
			@RequestParam(value = "positionId", required = false) Long[][] jobIds, RedirectAttributes redirectAttributes) {

		fillUserOrganization(m, organizationIds, jobIds);
		Assert.notNull(m);
		if (result.hasErrors()) {
	        if (!model.containsAttribute("m")) {
	            model.addAttribute("m", new User());
	            return "admin/sys/user/editForm";
	        }
        }
		return null;
	}

	private void fillUserOrganization(User m, Long[] organizationIds, Long[][] jobIds) {
		if (ArrayUtils.isEmpty(organizationIds)) {
			return;
		}
		for (int i = 0, l = organizationIds.length; i < l; i++) {

			// 仅新增/修改一个 spring会自动split（“，”）--->给数组
			if (l == 1) {
				for (int j = 0, l2 = jobIds.length; j < l2; j++) {
					UserOrganizationPosition userOrganizationJob = new UserOrganizationPosition();
					userOrganizationJob.setOrganizationId(organizationIds[i]);
					userOrganizationJob.setPositionId(jobIds[j][0]);
					m.addOrganizationJob(userOrganizationJob);
				}
			} else {
				Long[] jobId = jobIds[i];
				for (int j = 0, l2 = jobId.length; j < l2; j++) {
					UserOrganizationPosition userOrganizationJob = new UserOrganizationPosition();
					userOrganizationJob.setOrganizationId(organizationIds[i]);
					userOrganizationJob.setPositionId(jobId[j]);
					m.addOrganizationJob(userOrganizationJob);
				}
			}

		}
	}
	
}
