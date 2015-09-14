package com.petukhov.estate.service;

import java.util.List;

import com.petukhov.estate.domain.Hire;

public interface HireService {
	
	public void addHire(Hire hire);

    public List<Hire> listHire();
    
    public List<Hire> listUsernameHire(String username);

    public void removeHire(Integer id);
    
    public void removeEveryMatch(String username);
}
