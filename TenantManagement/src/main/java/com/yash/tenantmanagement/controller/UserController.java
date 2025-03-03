package com.yash.tenantmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.UserDto;
import com.yash.tenantmanagement.service.UserServiceInt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
* This is a User controller containing user Registration functionality
* @author amit joshi
*/
//@Api(value = "User Controller",tags = "User Management")
@Controller
public class UserController {

	@Autowired
	private UserServiceInt userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	/** This is a register method
	 * @return redirecting to login*/
	//@ApiOperation(value = "This functionality register user")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute UserDto user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			try {
			request.setAttribute("usernameError", result.getFieldError("username").getDefaultMessage());
			request.setAttribute("passwordError", result.getFieldError("password").getDefaultMessage());
			request.setAttribute("emailError", result.getFieldError("email").getDefaultMessage());
			request.setAttribute("phoneError", result.getFieldError("phone").getDefaultMessage());
			request.setAttribute("addressError", result.getFieldError("address").getDefaultMessage());
			return "register";
			}catch (Exception e) {
				System.out.println("Exception occur and handled here");
				return "register";
			}
		}

		User exitUser = this.userService.getUserByEmail(user.getEmail());
		if (exitUser != null) {
			System.out.println("Error");
			model.addAttribute("error", "Email already exist!!");
			return "register";
		}
		System.out.println("Username:" + user.getUsername());
		this.userService.registerUser(user);
		return "redirect:/login";
	}

	@RequestMapping(value = "/user_dashboard", method = RequestMethod.GET)
	public String userDashboard(Model model) {
		return "user_dashboard";
	}
	
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam Long userId,Model model) {
		System.out.println("Id is:"+userId);
		UserDto userDto = this.userService.getUserById(userId);
		System.out.println(userDto.getUsername());
		model.addAttribute("userDto",userDto);
		return "updateUser";
	}
	
	//@ApiOperation(value = "This functionality updating user")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute UserDto userDto,BindingResult result,Model model,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			try {
			request.setAttribute("usernameError", result.getFieldError("username").getDefaultMessage());
			request.setAttribute("passwordError", result.getFieldError("password").getDefaultMessage());
			request.setAttribute("emailError", result.getFieldError("email").getDefaultMessage());
			request.setAttribute("phoneError", result.getFieldError("phone").getDefaultMessage());
			request.setAttribute("addressError", result.getFieldError("address").getDefaultMessage());
			return "updateUser";
			}catch (Exception e) {
				System.out.println("Exception occur and handled here");
				return "updateUser";
			}
		}
		
		this.userService.updateUser(userDto);
		if(userDto.getUserId()==1L) {
		return "redirect:/user_list";
		}else {
			return "redirect:/propertyList";
		}
	}
    
    @GetMapping("userDelete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
      this.userService.deleteUser(userId);
      return "redirect:/user_list";
    }
    
	//@ApiOperation(value = "This functionality getting list of user")
    @RequestMapping(value = "/user_list", method = RequestMethod.GET)
    public String getUserList(Model model,@RequestParam(defaultValue = "0")int page,
    		@RequestParam(defaultValue = "5") int size,
    		@RequestParam(defaultValue = "username") String sort
    		) {
    	List<UserDto> userDtos = this.userService.getAllUsers(page,size,sort);
    	model.addAttribute("userDtos",userDtos);
    	model.addAttribute("currentPage",page);
    	model.addAttribute("pageSize",size);
    	model.addAttribute("totalUsers",userDtos.size());
    	model.addAttribute("sort",sort);
    	return "userList";
    }
    
	//@ApiOperation(value = "This functionality searching user")
    @RequestMapping(value = "/searchUser",method = RequestMethod.POST)
    public String searchUser(@RequestParam String username,@RequestParam String address,Model model) {
    	List<UserDto> userDtos = this.userService.searchUser(username, address);
    	model.addAttribute("userDtos",userDtos);
    	model.addAttribute("currentPage",0);
    	model.addAttribute("pageSize",0);
    	model.addAttribute("sort","username");
    	model.addAttribute("totalUsers",userDtos.size());
    	return "userList";
    }
	
	
}
