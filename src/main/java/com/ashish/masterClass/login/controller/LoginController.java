package com.ashish.masterClass.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashish.masterClass.login.service.AuthenticationService;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private AuthenticationService authService;

	public LoginController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authService.authentication(name,password)) {
			logger.info(name + " is logged-in");
			model.put("name", name);
			return "welcome";
		}
		
		model.put("InvalidUser", "User name and password is invalid. Please try again");
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String welcome() {
		return "login";
	}
		
	
}
