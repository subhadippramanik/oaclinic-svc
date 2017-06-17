package com.oaclinic.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {
	
	private static Logger LOGGER = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Session session;

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

	public Session validateUser(User user) {
		User validUser = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		if (Objects.nonNull(validUser)) {
			//TODO store session id to persistent data base
			session.setSessionId(UUID.randomUUID().toString());
			session.setUserName(validUser.getUserName());
		}
		return session;
	}

	public Boolean createUser(User user) {
		User userPresent = getUser(user.getUserName());
		if(Objects.isNull(userPresent)) {
			userRepository.save(user);
			return Boolean.TRUE;
		} else {
			LOGGER.error("Failed to create user! User already present with Full Name: " + userPresent.getFullName());
			return Boolean.FALSE;
		}
	}

}
