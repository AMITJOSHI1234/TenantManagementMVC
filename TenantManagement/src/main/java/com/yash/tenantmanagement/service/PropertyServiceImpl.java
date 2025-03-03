package com.yash.tenantmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Blob;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yash.tenantmanagement.dao.PropertyDaoInt;
import com.yash.tenantmanagement.domain.Property;
import com.yash.tenantmanagement.dto.PropertyDto;

/**
* This is a Property service implementation
* @author amit joshi
*/

@Service
@Transactional 
public class PropertyServiceImpl implements PropertyServiceInt {

	@Autowired
	private PropertyDaoInt propertyDao;
	
	/**
	Add Property Functionality
	 * @throws IOException 
	*/
	@Override
	public void addProperty(PropertyDto propertyDto,MultipartFile file) {
		Property property = new Property();
		System.out.println("abc:"+propertyDto.getAddress());
		property.setAddress(propertyDto.getAddress());
		property.setDescription(propertyDto.getDescription());
        property.setPrice(propertyDto.getPrice());
        property.setOwnerName(propertyDto.getOwnerName());
        try {
        	property.setImage(file.getBytes());
        }catch (Exception e) {
			e.printStackTrace();
		}
       
		
        this.propertyDao.addProperty(property);
	}
	/**
	Update Property Functionality
	 * @throws IOException 
	*/

	@Override
	public void updateProperty(PropertyDto propertyDto) {
		Property property = this.propertyDao.getPropertyById(propertyDto.getPropertyId());
		if(property!=null) {
			property.setAddress(propertyDto.getAddress());
			property.setDescription(propertyDto.getDescription());
            property.setPrice(propertyDto.getPrice());
            property.setOwnerName(propertyDto.getOwnerName());
            
            
            this.propertyDao.updateProperty(property);
		}
		
	}
	
	/**
	Delete Property Functionality
	*/

	@Override
	public void deleteProperty(Long propertyId) {
		this.propertyDao.deleteProperty(propertyId);
	}

	/**
	GetPropertyById functionality
	*/
	@Override
	public PropertyDto getPropertyById(Long propertyId) {
		Property property = this.propertyDao.getPropertyById(propertyId);
		if(property!=null) {
			PropertyDto propertyDto = new PropertyDto();
			propertyDto.setPropertyId(property.getPropertyId());
			propertyDto.setAddress(property.getAddress());
			propertyDto.setDescription(property.getDescription());
            propertyDto.setPrice(property.getPrice());
            propertyDto.setOwnerName(property.getOwnerName());
            return propertyDto;
		}
		return null;
	}

	/**
	Get all properties
	*/
	@Override
	public List<PropertyDto> getAllProperties() {
		List<Property> properties = this.propertyDao.getAllProperties();
		List<PropertyDto> propertyDtos = new ArrayList<PropertyDto>();
		for(Property property:properties) {
			PropertyDto dto = new PropertyDto();
			//System.out.println("Inside service:"+property.getImage().length);
			dto.setPropertyId(property.getPropertyId());
			dto.setAddress(property.getAddress());
			dto.setDescription(property.getDescription());
            dto.setPrice(property.getPrice());
            dto.setOwnerName(property.getOwnerName());  
            propertyDtos.add(dto);
		}
		return propertyDtos;
	}
	
	@Override
	public List<PropertyDto> searchProperties(PropertyDto propertyDto) {
		List<Property> properties = this.propertyDao.searchProperties(propertyDto);
		List<PropertyDto> propertyDtos = new ArrayList<PropertyDto>();
		
		for(Property property:properties) {
			PropertyDto dto = new PropertyDto();
			dto.setPropertyId(property.getPropertyId());
			dto.setAddress(property.getAddress());
			dto.setDescription(property.getDescription());
            dto.setPrice(property.getPrice());
            dto.setOwnerName(property.getOwnerName());
            System.out.println("Inside service of searchProperties:"+property.getOwnerName());
            propertyDtos.add(dto);
		}
		
		return propertyDtos;
	}
	@Override
	public Property getPropertyImage(Long id) {
		Property propertyDto = new Property();
		Property property = this.propertyDao.getPropertyImage(id);
		if(property!=null) {
			propertyDto.setPropertyId(property.getPropertyId());
			propertyDto.setAddress(property.getAddress());
			propertyDto.setDescription(property.getDescription());
			propertyDto.setOwnerName(property.getOwnerName());
			propertyDto.setPrice(property.getPrice());
			propertyDto.setImage(property.getImage());
			
			return propertyDto;
		}
		return null;
	}
	

}
