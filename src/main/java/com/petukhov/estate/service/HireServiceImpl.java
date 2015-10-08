package com.petukhov.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 



import com.petukhov.estate.dao.HireDAO;
import com.petukhov.estate.domain.Hire;
 
@Service
@Transactional
public class HireServiceImpl implements HireService {
 
    @Autowired
    private HireDAO hireDAO;
 
    @Override
    public void addHire(Hire contact) {
    	hireDAO.addHire(contact);
    }
 
    @Override
    public List<Hire> listHire() {
 
        return hireDAO.listHire();
    }
 
    @Override
    public void removeHire(Integer id) {
    	hireDAO.removeHire(id);
    }

	@Override
	public List<Hire> listUsernameHire(String username) {
		return hireDAO.listUsernameHire(username);
	}

	@Override
	public void removeEveryMatch(String username) {
		hireDAO.removeEveryMatch(username);
	}
    
}
