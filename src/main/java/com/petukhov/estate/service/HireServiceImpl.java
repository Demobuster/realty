package com.petukhov.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 


import com.petukhov.estate.dao.HireDAO;
import com.petukhov.estate.domain.Hire;
 
@Service
public class HireServiceImpl implements HireService {
 
    @Autowired
    private HireDAO hireDAO;
 
    @Override
    @Transactional
    public void addHire(Hire contact) {
    	hireDAO.addHire(contact);
    }
 
    @Override
    @Transactional
    public List<Hire> listHire() {
 
        return hireDAO.listHire();
    }
 
    @Override
    @Transactional
    public void removeHire(Integer id) {
    	hireDAO.removeHire(id);
    }

	@Override
	@Transactional
	public List<Hire> listUsernameHire(String username) {
		return hireDAO.listUsernameHire(username);
	}
    
}
