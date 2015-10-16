package com.petukhov.estate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String registration(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		
		try {
			Preconditions.checkArgument(!"".equals(username));
			Preconditions.checkArgument(!"".equals(password));
			
			password = new String(PasswordsHashing.getHashedPassword(password));
		} catch(IllegalArgumentException iae) {
			return "redirect:/login?error";
		}

		if (null != username && null != password) {
			Users user = new Users();
			UserRoles userRoles = new UserRoles();

			user.setUsername(username);
			user.setPassword(password);
			user.setEnabled(new Short("1"));

			// if user insertion fails, error page returned. further roles insertion prevented
			if (!usersService.addUser(user)) {
				return "redirect:/login?error"; 
			}

			userRoles.setUsername(username);
			userRoles.setUserRoleId((int) (Math.random() * 32000));
			userRoles.setRole("ROLE_USER");

			userRolesService.addUserRoles(userRoles);
		}

		return "redirect:/property"; 
	}
	
	@RequestMapping(value="/availability", method=RequestMethod.GET)
	@ResponseBody
	public AvailabilityStatus getAvailability(@RequestParam String username) {
		for (Users u : usersService.listUsers()) {
			if ((u.getUsername().toLowerCase()).equals(username.toLowerCase())) {
				return AvailabilityStatus.notAvailable(username);
			}
		}
		
		return AvailabilityStatus.available();
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView getRegistrationPage() {
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value = { "/well" }, method = RequestMethod.GET)
	public ModelAndView getWellPage() {
		return new ModelAndView("well");
	}
	
	@RequestMapping(value = { "/tempPage" }, method = RequestMethod.GET)
	public ModelAndView getTempPage() {
		return new ModelAndView("tempPage");
	}
} 


//////////////////////////////////////////////////

class PasswordsHashing {
	public static String getHashedPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return new String(passwordEncoder.encode(password));
	}
}

class AvailabilityStatus {

	public boolean isAvailable() {
		return available;
	}
	
	public String[] getSuggestions() {
		return suggestions;
	}
	
	public static AvailabilityStatus available() {
		return AVAILABLE_INSTANCE;
	}

	public static AvailabilityStatus notAvailable(String name) {
		String[] suggestions = new String[3];
		for (int i = 0; i < suggestions.length; i++) {
			suggestions[i] = name + (i + 1);
		}
		return new AvailabilityStatus(false, suggestions);
	}
	
	// internal
	
	private static final AvailabilityStatus AVAILABLE_INSTANCE = new AvailabilityStatus(true, new String[0]);
	
	private boolean available;
	
	private String[] suggestions;
	
	private AvailabilityStatus(boolean available, String[] suggestions) {
		this.available = available;
		this.suggestions = suggestions;
	}
	
}