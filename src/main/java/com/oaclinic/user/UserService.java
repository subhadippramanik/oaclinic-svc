package com.oaclinic.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static Logger LOGGER = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;	

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

	public Boolean isValidUser(User user) {
		User userPresent = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		if (userIsValidAndActive(userPresent)) {
			return Boolean.TRUE;

		} else {
			throw new RuntimeException(
					"Failed to validate user! Either user name password is not valid or user is not active");
		}
	}

	private boolean userIsValidAndActive(User userPresent) {
		return Objects.nonNull(userPresent) && userPresent.isActive();
	}

	public Boolean createUser(User user) {
		User userPresent = getUser(user.getUserName());
		if (Objects.isNull(userPresent)) {
			userRepository.save(user);
			return Boolean.TRUE;
		} else {
			LOGGER.error("Failed to create user! User already present with Full Name: " + userPresent.getFullName());
			return Boolean.FALSE;
		}
	}

}
