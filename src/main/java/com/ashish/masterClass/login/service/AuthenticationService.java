package com.ashish.masterClass.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authentication(String userName, String password) {
		return userName.equalsIgnoreCase("ashish") && password.equalsIgnoreCase("dummy");
	}
	

}
