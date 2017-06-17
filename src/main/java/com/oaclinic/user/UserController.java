package com.oaclinic.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users")
	public List<User> showAllUsers() {
		List<User> logins = userService.getUsers();
		return logins;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public HttpStatus createUser(@RequestBody User user) {
		Boolean isCreated = userService.createUser(user);
		if(isCreated) {
			LOGGER.debug("User created " + user.getUserName());
			return HttpStatus.CREATED;
		} else {
			return HttpStatus.CONFLICT;
		}
	}

	@RequestMapping(value = "/login/{userId}", method = RequestMethod.POST)
	public Session login(@PathVariable String userId, @RequestBody User user) {
		user.setUserName(userId);
		LOGGER.info("Login request from user " + userId);
		Session session = userService.validateUser(user);
		return session;
	}
}
