package com.yash.tenantmanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

/**
* This is a Property Dto
* @author amit joshi
*/
public class PropertyDto {

	private Long propertyId;
	
	@NotBlank(message = "Address is required!!")
	private String address;
	
    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private Long price;

    @NotBlank(message = "Owner name is required")
    private String ownerName;
    


	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	@Override
	public String toString() {
		return "PropertyDto [propertyId=" + propertyId + ", address=" + address + ", description=" + description
				+ ", price=" + price + ", ownerName=" + ownerName + "]";
	}

	    

}
