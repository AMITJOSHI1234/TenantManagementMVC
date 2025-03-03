package com.yash.tenantmanagement.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yash.tenantmanagement.domain.User;
import com.yash.tenantmanagement.dto.LoginDto;
import com.yash.tenantmanagement.service.UserServiceInt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* This is a login controller containing login and logout functionality
* @author amit joshi
*/

//@Api(value = "Login Controller", tags = "Login Management for User and Admin")
@Controller
public class LoginController {

	@Autowired
	private UserServiceInt userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login",new LoginDto());
		return "login";
	}
	
	/** This is a login method
	 * @return login*/
	//@ApiOperation(value = "Login operation")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute LoginDto login,BindingResult result,Model model,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("Inside error box of login!!!");
			try {
			request.setAttribute("emailError", result.getFieldError("email").getDefaultMessage());
			}catch (Exception e) {
				System.out.println("Exception in email");
			}
			System.out.println("Hello world!!!!");
			try {
			request.setAttribute("passwordError", result.getFieldError("password").getDefaultMessage());
			}catch (Exception e) {
			   System.out.println("Excption in password");
			}
			return "login";
		}
		
		User user = this.userService.getUserByEmail(login.getEmail());
		if(user==null || !user.getPassword().equals(login.getPassword())) {
			model.addAttribute("error","Invalid email or password!!!");
			return "login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("userName", user.getUsername());
		session.setAttribute("roleId", user.getRole());
		session.setAttribute("userId", user.getUserId());
		if(user.getRole()==1L) {
			session.setAttribute("name", user.getUsername());
			return "redirect:/propertyList";
		}else {
			session.setAttribute("name", user.getUsername());
			return "redirect:/propertyList";
		}
	}
	/** This is a logout method
	 * @return login page*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		System.out.println("Inside logout functionality!");
	    HttpSession session = request.getSession();
	    session.invalidate();
	    return "redirect:/login";
	}
	
	
}
