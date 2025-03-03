package com.yash.tenantmanagement.dao;

import java.util.List;

import com.yash.tenantmanagement.domain.Property;
import com.yash.tenantmanagement.dto.PropertyDto;

public interface PropertyDaoInt {

	void addProperty(Property property);
	
	void updateProperty(Property property);
	
	void deleteProperty(Long propertyId);
	
	Property getPropertyById(Long propertyId);
	
	List<Property> getAllProperties();
	
	List<Property> searchProperties(PropertyDto propertyDto);
	
	public Property getPropertyImage(Long id);
}
