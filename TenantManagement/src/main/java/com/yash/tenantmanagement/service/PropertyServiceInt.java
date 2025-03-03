package com.yash.tenantmanagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yash.tenantmanagement.domain.Property;
import com.yash.tenantmanagement.dto.PropertyDto;

public interface PropertyServiceInt {

    void addProperty(PropertyDto propertyDto,MultipartFile file);

    void updateProperty(PropertyDto propertyDto);

    void deleteProperty(Long propertyId);

    PropertyDto getPropertyById(Long propertyId);

    List<PropertyDto> getAllProperties();
    
    List<PropertyDto> searchProperties(PropertyDto propertyDto);

    Property getPropertyImage(Long id);
}
