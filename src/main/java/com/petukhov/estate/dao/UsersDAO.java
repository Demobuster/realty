package com.petukhov.estate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Users;

public interface UsersDAO {
	public boolean addUser(Users user);

	public List<Users> listUsers();
	
	public void removeUser(String username);
}
