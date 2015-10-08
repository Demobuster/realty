package com.petukhov.estate.service;

import java.util.List;

import com.petukhov.estate.domain.Prop;

public interface PropertyService {
	
	public void addProperty(String address, String description, String fee);
	
	public List<Prop> listProperty();
	
	public List<Prop> listPropertyForAdmin();
	
	public Prop getProperty(String id);
	
	public void removeProperty(String id);
	
	public void indexProperty() throws Exception;
	
	public List<Prop> searchForProperty(String searchText) throws Exception;
}
