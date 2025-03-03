/**
* This is a Admin controller containing login and logout functionality
* @author amit joshi
*/
package com.yash.tenantmanagement.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yash.tenantmanagement.dto.PropertyDto;
import com.yash.tenantmanagement.service.PropertyServiceInt;
import com.yash.tenantmanagement.service.UserServiceInt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Admin controller",tags = "Admin management")
@Controller
public class AdminController {
	@Autowired
	private PropertyServiceInt propertyService;
	
	@Autowired
	private UserServiceInt userService;

	@RequestMapping(value = "/admin_dashboard", method = RequestMethod.GET)
	public String adminDashboard(Model model) {
		return "admin_dashboard";
	}
	
	/**
	This is functionality for add property
	*/
	@RequestMapping(value = "/addProperty", method = RequestMethod.GET)
	public String addProperty(Model model) {
		model.addAttribute("propertyDto", new PropertyDto());
		return "addProperty";
	}
	
	//@ApiOperation(value = "Add property ")
	@RequestMapping(value = "/addProperty", method = RequestMethod.POST)
	public String addProperty(@Valid @ModelAttribute PropertyDto propertyDto, BindingResult result, 
			HttpServletRequest request,@RequestParam MultipartFile image,Model model) throws IOException {
		System.out.println("Inside addProperty");
		System.out.println(propertyDto.getAddress());
		System.out.println(image.getName().getBytes());
		
	    if (result.hasErrors()) {
	  
	    	    try {
				model.addAttribute("address",result.getFieldError("address").getDefaultMessage());
	    	    }catch (Exception e) {
					System.out.println("Inside address error");
				}
	    	    
	    	    try {
				model.addAttribute("description", result.getFieldError("description").getDefaultMessage());
	    	    }catch (Exception e) {
				    System.out.println("Inside description error");
				}
	    	    
	    	    try {
	            model.addAttribute("price", result.getFieldError("price").getDefaultMessage());
	    	    }catch (Exception e) {
					System.out.println("Inside price error!!!");
				}
	    	    
	    	    try {
	            model.addAttribute("ownerName", result.getFieldError("ownerName").getDefaultMessage());
	    	    }catch (Exception e) {
					System.out.println("Inside ownerName error");
				}
	    	    
	    	    try {
                model.addAttribute("imageError", result.getFieldError("image").getDefaultMessage());
	    	    }catch (Exception e) {
					System.out.println("Inside imageError!!!");
				}
	            return "addProperty";
	    }
	    
		/*
		 * if (image != null) { try { propertyDto.setImage(image); } catch (Exception e)
		 * { request.setAttribute("imageError", "Error uploading image"); return
		 * "addProperty"; } }
		 */
	    
	    this.propertyService.addProperty(propertyDto,image);
		return "redirect:/propertyList";
	}
	
	@GetMapping("{propertyId}")
	public String updateProperty(@PathVariable Long propertyId,Model model) {
		PropertyDto propertyDto = this.propertyService.getPropertyById(propertyId);
		model.addAttribute("propertyDto",propertyDto);
		return "updateProperty";
	}
	
	//@ApiOperation(value = "Update Property")
	@PostMapping("/update")
	public String updateProperty(@Valid @ModelAttribute PropertyDto propertyDto,BindingResult result,Model model) throws IOException {
		if(result.hasErrors()) {
			try {
			model.addAttribute("addressError",result.getFieldError("address").getDefaultMessage());
			model.addAttribute("descriptionError", result.getFieldError("description").getDefaultMessage());
            model.addAttribute("priceError", result.getFieldError("price").getDefaultMessage());
            model.addAttribute("ownerNameError", result.getFieldError("ownerName").getDefaultMessage());
            model.addAttribute("imageError", result.getFieldError("image").getDefaultMessage());
            return "updateProperty";
			}catch (Exception e) {
				System.out.println("Exception occur and handled here");
				return "updateProperty";
			}
		}
		this.propertyService.updateProperty(propertyDto);
		return "redirect:/propertyList";
	}
	
	@GetMapping("/delete/{propertyId}")
	public String deleteProperty(@PathVariable Long propertyId) {
		this.propertyService.deleteProperty(propertyId);
		return "redirect:/propertyList";
	}
	

	
}