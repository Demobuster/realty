package com.petukhov.estate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Hire;

public interface HireDAO {

    public void addHire(Hire hire);

    public List<Hire> listHire();
    
    public List<Hire> listUsernameHire(String username);

    @Transactional
    public void removeHire(Integer id);
    
    @Transactional
    public void removeEveryMatch(String username);
}
