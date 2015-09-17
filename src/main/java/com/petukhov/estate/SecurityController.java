package com.petukhov.estate;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petukhov.estate.service.UsersService;

@Controller
public class SecurityController {
	
	@Autowired
	private UsersService usersService;
	
	private String backgroundIMG = "https://googledrive.com/host/0BweevD4Le1puMnhkcXhCUlV0WXM";
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public String defaultPage() {
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public ModelAndView getWelcomePage(Device device) {		
		ModelAndView mav = new ModelAndView("welcome");
		
		if (device.isMobile() || device.isTablet()) {
			backgroundIMG = "https://googledrive.com/host/0BweevD4Le1pueGFyOFUxcmo3ZWM";
		} 
			
		mav.addObject("backgroundIMG", backgroundIMG);
	
		return mav;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title",
				"Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
															  HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("welcome");
			
			model.addObject("backgroundIMG", backgroundIMG);
			
			return model;
		}
		
		if (request.isUserInRole("ROLE_ADMIN")) {
			request.getSession().setAttribute("isAdmin", "true");
		} 
		
		model.setViewName("login");

		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;

	}
}
