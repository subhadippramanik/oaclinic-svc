package com.oaclinic.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public List<Login> getAllLogins() {
		List<Login> logins = new ArrayList<>();
		loginRepository.findAll().forEach(logins :: add);
		return logins;
	}

	public int validateLogin(String username, String userpwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Login getLoginByName(String username, String userpwd) {
		 return loginRepository.findByUserNameAndUserPassword(username, userpwd);
	}
}
