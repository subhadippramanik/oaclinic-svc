package com.oaclinic.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oaclinic.session.Session;

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

	@RequestMapping(value = "/login/{userName}", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@PathVariable String userName, @RequestBody User user) {
		user.setUserName(userName);
		LOGGER.info("Login request from user " + userName);
		try {
			Session session = userService.validateUser(user);
			return new ResponseEntity<Object>(session, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/logout/{userName}", method = RequestMethod.POST)
	public HttpStatus logout(@PathVariable String userName, @RequestHeader("session-id") String sessionId) {
		userService.invalidateSession(userName, sessionId);
		return HttpStatus.OK;
	}
}
