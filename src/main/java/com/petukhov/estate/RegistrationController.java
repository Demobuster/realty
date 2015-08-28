package com.petukhov.estate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;
import com.petukhov.estate.domain.UserRoles;
import com.petukhov.estate.domain.Users;
import com.petukhov.estate.service.UserRolesService;
import com.petukhov.estate.service.UsersService;

@Controller
public class RegistrationController {

	@Autowired
	private UserRolesService userRolesService;

	@Autowired
	private UsersService usersService;
	
	@Transactional
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String registration(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		
		try {
			Preconditions.checkArgument(!"".equals(username));
			Preconditions.checkArgument(!"".equals(password));
		} catch(IllegalArgumentException iae) {
			return "redirect:/login?error";
		}

		if (username != null && password != null) {
			Users user = new Users();
			UserRoles userRoles = new UserRoles();

			user.setUsername(username);
			user.setPassword(password);
			user.setEnabled(new Short("1"));

			usersService.addUser(user);

			userRoles.setUsername(username);
			userRoles.setUserRoleId((int) (Math.random() * 32000));
			userRoles.setRole("ROLE_USER");

			userRolesService.addUserRoles(userRoles);
		}

		return "redirect:/property"; 
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView getRegistrationPage() {
		return new ModelAndView("registration");
	}
	
}
