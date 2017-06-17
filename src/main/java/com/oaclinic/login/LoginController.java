package com.oaclinic.login;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/logins")
	 public List<Login> showAllLogins() {	 
	 List<Login> logins=loginService.getAllLogins();
	 return logins;	
	 }
	
	@RequestMapping(value="/logins/{username}/{userpwd}")
	 public int checkLogin(@PathVariable String username,@PathVariable String userpwd)throws ParseException {	 
	 int chkUser = loginService.validateLogin(username,userpwd);
	  	return chkUser;	
	 }
	
	@RequestMapping(value="/chklogin/{username}/{userpwd}")
	 public Login checkUser(@PathVariable String username,@PathVariable String userpwd)throws ParseException {	 
	 Login login = loginService.getLoginByName(username,userpwd);
	 return login;	
	 }
}
