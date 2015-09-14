package com.petukhov.estate.dao;

import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.UserRoles;

public interface UserRolesDAO {
	public void addUserRoles(UserRoles userRoles);
	
	@Transactional
	public void removeUser(String username);
}
