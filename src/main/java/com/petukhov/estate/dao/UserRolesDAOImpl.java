package com.petukhov.estate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petukhov.estate.domain.UserRoles;

@Repository
public class UserRolesDAOImpl implements UserRolesDAO {
	
	@Autowired
    private SessionFactory mySessionFactory;

	@Override
	public void addUserRoles(UserRoles userRoles) {
		mySessionFactory.getCurrentSession().save(userRoles);
	}

}
