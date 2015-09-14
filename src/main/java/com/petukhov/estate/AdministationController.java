package com.petukhov.estate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petukhov.estate.domain.PropModel;
import com.petukhov.estate.service.HireService;
import com.petukhov.estate.service.UserRolesService;
import com.petukhov.estate.service.UsersService;

@Controller
public class AdministationController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private HireService hireService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboardPage() {
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping(value = "/usersManagement", method = RequestMethod.GET)
	public ModelAndView usersManagementPage() {
		ModelAndView mav = new ModelAndView("usersManagement");
		return mav;
	}
	
	@RequestMapping(value = "/addProperty", method = RequestMethod.GET)
	public ModelAndView addPropertyPage() {
		ModelAndView mav = new ModelAndView("addProperty", "command", new PropModel());
		return mav;
	}
	
	@Transactional
	@RequestMapping(value = { "getUsersList" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> usersList() {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usersList", usersService.listUsers());
		
		return map;
	}
	
	@Transactional
	@RequestMapping(value = { "/deleteUser/{username}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable("username") String username) {
		usersService.removeUser(username);
		userRolesService.removeUser(username);
		hireService.removeEveryMatch(username);

		return "redirect:/usersManagement";
	}
}
