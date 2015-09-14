package com.petukhov.estate.service;

import com.petukhov.estate.domain.UserRoles;

public interface UserRolesService {
	public void addUserRoles(UserRoles userRoles);
	
	public void removeUser(String username);
}
