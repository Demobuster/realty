package com.petukhov.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petukhov.estate.dao.PropertyDAO;
import com.petukhov.estate.domain.Prop;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
    private PropertyDAO propertyDAO;
	
	@Override
	@Transactional
	public void addProperty(String address, String description, String fee) {
		propertyDAO.addProperty(address, description, fee);
	}

	@Override
	@Transactional
	public List<Prop> listProperty() {
		return propertyDAO.listProperty();
	}

	@Override
	public Prop getProperty(String id) {
		return propertyDAO.getProperty(id);
	}

	@Override
	@Transactional
	public void indexProperty() throws Exception {
		propertyDAO.indexProperty();
	}

	@Override
	@Transactional
	public List<Prop> searchForProperty(String searchText) throws Exception {
		return propertyDAO.searchForProperty(searchText);
	}
	
}
