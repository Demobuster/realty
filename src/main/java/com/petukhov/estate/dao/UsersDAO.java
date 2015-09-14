package com.petukhov.estate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Users;

public interface UsersDAO {
	public void addUser(Users user);
	
	@Transactional
	public List<Users> listUsers();
	
	@Transactional
	public void removeUser(String username);
}
