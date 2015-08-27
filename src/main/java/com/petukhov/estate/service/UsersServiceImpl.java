package com.petukhov.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petukhov.estate.dao.UsersDAO;
import com.petukhov.estate.domain.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public void addUser(Users user) {
		usersDAO.addUser(user);
	}

}
