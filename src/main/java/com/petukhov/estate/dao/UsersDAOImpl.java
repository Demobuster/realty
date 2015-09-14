package com.petukhov.estate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
    private SessionFactory mySessionFactory;

	@Override
	public void addUser(Users user) {
		mySessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Users> listUsers() {
		return mySessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		Users user = (Users) mySessionFactory.getCurrentSession().get(Users.class, username);
		
        if (null != user) {
            mySessionFactory.getCurrentSession().delete(user);
        }
	}

}
