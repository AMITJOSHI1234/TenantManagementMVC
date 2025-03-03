package com.yash.tenantmanagement.controller;
/**
* This is a Property controller containing login and logout functionality
* @author amit joshi
*/
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.tenantmanagement.domain.Property;
import com.yash.tenantmanagement.dto.PropertyDto;
import com.yash.tenantmanagement.service.PropertyServiceInt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Property Controller",tags = "Property Management")
@Controller
public class PropertyController {

	@Autowired
	private PropertyServiceInt propertyService;
	
	/**
	* Getting list of all properties
	*/
	//@ApiOperation(value = "Getting list of properties")
	@GetMapping("propertyList")
    public String getAllProperties(Model model,HttpSession session) {
        List<PropertyDto> properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        model.addAttribute("roleId",1L);
        model.addAttribute("propertyDto", new PropertyDto()); 
        return "propertyList";
    }	
	
	/**
	* This is for searching properties
	*/
	//@ApiOperation(value = "Searching Properties")
	@PostMapping("searchProperty")
	public String searchProperty(@ModelAttribute PropertyDto propertyDto,Model model) {
		System.out.println("Inside search Property method!!!");
		List<PropertyDto> properties = this.propertyService.searchProperties(propertyDto);
		for(PropertyDto p:properties) {
			System.out.println(p);
		}
		model.addAttribute("properties",properties);
		return "propertyList";
	}
	/**
	* This handler getting images from database
	*/
	//@ApiOperation(value = "Getting image")
	@GetMapping("getImage")
	public String getImage(@RequestParam Long propId,HttpSession session) {
		Property propertyDto = this.propertyService.getPropertyImage(propId);
		String propertyImage = Base64.getEncoder().encodeToString(propertyDto.getImage());
		session.setAttribute("image", propertyImage);
		return "viewPropertyImage";
	}
}
