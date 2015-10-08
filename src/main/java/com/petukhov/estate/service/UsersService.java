package com.petukhov.estate.service;

import java.util.List;

import com.petukhov.estate.domain.Users;

public interface UsersService {

	public boolean addUser(Users user);
	
	public List<Users> listUsers();
	
	public void removeUser(String username);
	
}
