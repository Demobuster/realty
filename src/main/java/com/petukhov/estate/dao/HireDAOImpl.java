package com.petukhov.estate.dao;

import java.util.List;

import com.petukhov.estate.domain.Hire;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HireDAOImpl implements HireDAO {

    @Autowired
    private SessionFactory mySessionFactory;

    public void addHire(Hire hire) {
        mySessionFactory.getCurrentSession().save(hire);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hire> listHire() {
    	
        return mySessionFactory.getCurrentSession().createQuery("from Hire").list();
    }
    
    @Override
    public void removeHire(Integer id) {
    	Hire hire = (Hire) mySessionFactory.getCurrentSession().get(Hire.class, id);
    	
        if (null != hire) {
            mySessionFactory.getCurrentSession().delete(hire);
        }
    	
//    	mySessionFactory.getCurrentSession().createQuery("DELETE FROM Hire H WHERE H.id = :id")
//		.setParameter("id", id);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Hire> listUsernameHire(String username) {
		return mySessionFactory.getCurrentSession().createQuery("FROM Hire H WHERE H.username = :username")
				.setParameter("username", username)
				.list();
	}
}
