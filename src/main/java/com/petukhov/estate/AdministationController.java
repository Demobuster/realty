package com.petukhov.estate;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Charsets;
import com.petukhov.estate.domain.Prop;
import com.petukhov.estate.domain.PropModel;
import com.petukhov.estate.service.HireService;
import com.petukhov.estate.service.PropertyService;
import com.petukhov.estate.service.UserRolesService;
import com.petukhov.estate.service.UsersService;

@Controller
public class AdministationController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private HireService hireService;
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboardPage(HttpServletRequest request) {
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
	
	@RequestMapping(value = "/addPropertyToDB", method = RequestMethod.POST)
	public ModelAndView addPropertyToDB(
			@ModelAttribute("PropModel") PropModel propInfo) throws Exception {

		propertyService.addProperty(propInfo.getPropAddress(),
									propInfo.getPropDescription(), 
									propInfo.getPropFee());

		byte[] utf8AddressBytes = propInfo.getPropAddress().getBytes(Charsets.UTF_8);
		byte[] utf8DescriptionBytes = propInfo.getPropDescription().getBytes(Charsets.UTF_8);
		byte[] utf8FeeBytes = propInfo.getPropFee().getBytes(Charsets.UTF_8);

		String utf8ResultAddress = new String(utf8AddressBytes, Charsets.UTF_8);
		String utf8ResultDescription = new String(utf8DescriptionBytes, Charsets.UTF_8);
		String utf8ResultFee = new String(utf8FeeBytes, Charsets.UTF_8);

		ModelAndView mav = new ModelAndView("done");
		mav.addObject("address", utf8ResultAddress);
		mav.addObject("description", utf8ResultDescription);
		mav.addObject("fee", utf8ResultFee);

		return mav;
	}
	
	@RequestMapping(value = { "/propManagement" }, method = RequestMethod.GET)
	public ModelAndView getPropManagement() {
		ModelAndView model = new ModelAndView();
		model.addObject("property", new Prop());
		model.addObject("propertyListForAdmin", propertyService.listPropertyForAdmin());
		model.setViewName("propManagement");

		return model;
	}
	
	@RequestMapping(value = { "getUsersList" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> usersList() {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usersList", usersService.listUsers());
		
		return map;
	}
	
	@RequestMapping(value = { "/deleteUser/{username}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable("username") String username) {
		usersService.removeUser(username);
		userRolesService.removeUser(username);
		hireService.removeEveryMatch(username);

		return "redirect:/usersManagement";
	}

	@RequestMapping(value = { "/deleteProp/{propId}" }, method = RequestMethod.GET)
	public String deleteProp(@PathVariable("propId") String propId) {

		propertyService.removeProperty(propId);

		return "redirect:/propManagement";
	}
}
