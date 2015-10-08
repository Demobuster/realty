package com.petukhov.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.dao.UsersDAO;
import com.petukhov.estate.domain.Users;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public boolean addUser(Users user) {
		return usersDAO.addUser(user);
	}

	@Override
	public List<Users> listUsers() {
		return usersDAO.listUsers();
	}

	@Override
	public void removeUser(String username) {
		usersDAO.removeUser(username);
	}

}
