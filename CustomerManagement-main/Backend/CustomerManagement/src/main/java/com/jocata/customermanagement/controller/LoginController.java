package com.jocata.customermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping("/login")
	public @ResponseBody String loginDetails(@RequestBody Login login) throws Exception
	{
		return loginService.checkLoginCredentials(login);
	}

}
