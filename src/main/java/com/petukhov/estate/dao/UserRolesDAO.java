package com.petukhov.estate.dao;

import com.petukhov.estate.domain.UserRoles;

public interface UserRolesDAO {
	public void addUserRoles(UserRoles userRoles);
	
	public void removeUser(String username);
}
