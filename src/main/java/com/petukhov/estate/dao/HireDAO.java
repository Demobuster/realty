package com.petukhov.estate.dao;

import java.util.List;

import com.petukhov.estate.domain.Hire;

public interface HireDAO {

    public void addHire(Hire hire);

    public List<Hire> listHire();
    
    public List<Hire> listUsernameHire(String username);

    public void removeHire(Integer id);
}
