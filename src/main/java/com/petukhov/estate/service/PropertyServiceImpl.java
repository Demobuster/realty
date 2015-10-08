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
	public void addProperty(String address, String description, String fee) {
		propertyDAO.addProperty(address, description, fee);
	}

	@Override
	public List<Prop> listProperty() {
		return propertyDAO.listProperty();
	}
	
	@Override
	public List<Prop> listPropertyForAdmin() {
		return propertyDAO.listPropertyForAdmin();
	}

	@Override
	public Prop getProperty(String id) {
		return propertyDAO.getProperty(id);
	}
	
	@Override
	public void removeProperty(String id) {
		propertyDAO.removeProperty(id);
	}
	
	@Override
	public void indexProperty() throws Exception {
		propertyDAO.indexProperty();
	}

	@Override
	public List<Prop> searchForProperty(String searchText) throws Exception {
		return propertyDAO.searchForProperty(searchText);
	}

}
