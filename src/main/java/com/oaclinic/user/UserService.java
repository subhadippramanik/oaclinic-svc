package com.oaclinic.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oaclinic.session.Session;
import com.oaclinic.session.SessionRepository;

@Service
public class UserService {

	private static Logger LOGGER = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Session session;

	@Autowired
	SessionRepository sessionRepository;

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

	public Session validateUser(User user) {
		User userPresent = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
		if (userIsValidAndActive(userPresent)) {
			session.setSessionId(UUID.randomUUID().toString());
			session.setUserName(userPresent.getUserName());
			session.setTimeStamp(new Timestamp(System.currentTimeMillis()));
			try {
				sessionRepository.save(session);
			} catch (Exception e) {
				LOGGER.error("Failed to save session!");
				throw new RuntimeException(e);
			}

		} else {
			throw new RuntimeException(
					"Failed to validate user! Either user name password is not valid or user is not active");
		}
		return session;
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

	public void invalidateSession(String userName, String sessionId) {
		session.setSessionId(sessionId);
		session.setUserName(userName);
		sessionRepository.delete(session);
	}

}
