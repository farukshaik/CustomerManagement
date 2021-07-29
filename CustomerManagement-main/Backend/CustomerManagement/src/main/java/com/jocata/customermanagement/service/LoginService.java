package com.jocata.customermanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.customermanagement.entity.LoginEntity;
import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.repository.LoginRepository;


@Service
public class LoginService {
	
	@Autowired
	public LoginEntity loginEntity;
	
	@Autowired 
	public LoginRepository loginRepository;

	public String checkLoginCredentials(Login login) throws Exception{
		
			int flag=0;
			String passwordFromDb= null;
			
			String userNameFromUi=login.getUserName();
			String passWordFromUi=login.getPassWord();
			
			try
			{
				LoginEntity row=loginRepository.findByUserName(userNameFromUi);
				passwordFromDb=row.getPassWord();
			}
			catch(Exception e)
			{
				return "No such user Exists...";
			}
			
			if(passWordFromUi.equals(passwordFromDb)) flag=1;
			
			if(flag==1)
				return "success";
			
			else
				return "wrong password";
			
			
	}

}
