package com.petukhov.estate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petukhov.estate.domain.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
    private SessionFactory mySessionFactory;

	@Override
	public void addUser(Users user) {
		mySessionFactory.getCurrentSession().save(user);
	}

}
