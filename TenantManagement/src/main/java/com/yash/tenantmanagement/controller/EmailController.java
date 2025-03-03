package com.yash.tenantmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.tenantmanagement.dto.UserDto;
import com.yash.tenantmanagement.service.EmailService;
import com.yash.tenantmanagement.service.UserServiceInt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Email Controller",tags = "Email Management")
@Controller
public class EmailController {

	public final EmailService emailService;
	
	@Autowired
	public UserServiceInt userService;
	
	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	//@ApiOperation(value = "Sending Emails")
	@GetMapping("userDetails")
	public String getUserDetail(@RequestParam Long id) {
		UserDto user = this.userService.getUserById(id);
		sendEmail(user.getEmail(), "Confirmation", "Hi "+user.getUsername()+" Thankyou for selecting us now admin will contact you!!!");
		return "mailPage";
	}
	
	public void sendEmail(String to,String subject,String body) {
		this.emailService.sendEmail(to, subject, body);
	}
}
