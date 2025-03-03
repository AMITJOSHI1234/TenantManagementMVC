package com.yash.tenantmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/yash/hello")
	public String yashWorld() {
		return "welcome";
	}
}
