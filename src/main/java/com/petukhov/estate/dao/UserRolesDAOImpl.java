package com.petukhov.estate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Hire;
import com.petukhov.estate.domain.UserRoles;

@Repository
public class UserRolesDAOImpl implements UserRolesDAO {
	
	@Autowired
    private SessionFactory mySessionFactory;

	@Override
	public void addUserRoles(UserRoles userRoles) {
		mySessionFactory.getCurrentSession().save(userRoles);
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		UserRoles user = (UserRoles) mySessionFactory.getCurrentSession()
													 .createQuery("FROM UserRoles H WHERE H.username = :username")
													 .setParameter("username", username)
													 .list().get(0);
    	
        if (null != user) {
            mySessionFactory.getCurrentSession().delete(user);
        }
	}

}
