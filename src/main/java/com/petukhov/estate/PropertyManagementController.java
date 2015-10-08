package com.petukhov.estate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petukhov.estate.domain.Hire;
import com.petukhov.estate.domain.Prop;
import com.petukhov.estate.service.HireService;
import com.petukhov.estate.service.PropertyService;

@Controller
public class PropertyManagementController { 

	@Autowired
	private HireService hireService;

	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(value = { "/hire/{propId}" }, method = RequestMethod.GET)
	public String addHire(@PathVariable("propId") String propId) {

		Prop prop = propertyService.getProperty(propId);
		Hire hire = new Hire();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		if (null != prop) {
			hire.setUsername(userDetail.getUsername());
			hire.setAddress(prop.getAddress());
			hire.setFee(Integer.parseInt(prop.getFee()));
			
			hireService.addHire(hire);
		} else {
			return "redirect:/property";
		}
		
		return "redirect:/userPage";
	}

	@RequestMapping(value = { "getUsersHire" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUsersHireByJSON() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		String username = userDetail.getUsername();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hires", hireService.listUsernameHire(username));
		
		return map;
	}
	
	@RequestMapping(value = { "/delete/{propId}" }, method = RequestMethod.GET)
	public String deleteHire(@PathVariable("propId") Integer propId) {

		hireService.removeHire(propId);

		ModelAndView model = new ModelAndView();
		model.setViewName("property");

		return "redirect:/userPage";
	}
	
	@RequestMapping(value = { "property" }, method = RequestMethod.GET)
	public ModelAndView propertyPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("property", new Prop());
		model.addObject("propertyList", propertyService.listProperty());
		model.setViewName("property");

		return model;
	}
	
	@RequestMapping(value = { "/userPage" }, method = RequestMethod.GET)
	public ModelAndView userPage() {
		return new ModelAndView("userPage");
	}
	
}
