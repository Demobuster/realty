package com.petukhov.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.dao.UserRolesDAO;
import com.petukhov.estate.domain.UserRoles;

@Service
@Transactional
public class UserRolesServiceImpl implements UserRolesService {
	
	@Autowired
	private UserRolesDAO userRolesDAO;

	@Override
	public void addUserRoles(UserRoles userRoles) {
		userRolesDAO.addUserRoles(userRoles);
	}

	@Override
	public void removeUser(String username) {
		userRolesDAO.removeUser(username);
	}

}
