package com.petukhov.estate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petukhov.estate.domain.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
    private SessionFactory mySessionFactory;

	@Override
	public boolean addUser(Users user) {
		
		for (Users u : this.listUsers()) {
			if (null != u && u.getUsername().equals(user.getUsername())) {
				// if users exist we have to return false value, because it'll mean that insertion failed
				return false;
			}
		}
		
		mySessionFactory.getCurrentSession().save(user);	
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listUsers() {
		return mySessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	public void removeUser(String username) {
		Users user = (Users) mySessionFactory.getCurrentSession().get(Users.class, username);
		
        if (null != user) {
            mySessionFactory.getCurrentSession().delete(user);
        }
	}

}
