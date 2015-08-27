package com.petukhov.estate.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.domain.Prop;

@Transactional
public interface PropertyDAO {

	public void addProperty(String address, String description, String fee);
	
	@Transactional
	public List<Prop> listProperty();

	public Prop getProperty(String id);
	
	public void indexProperty() throws Exception;
	
	public List<Prop> searchForProperty(String searchText) throws Exception;
	
}
