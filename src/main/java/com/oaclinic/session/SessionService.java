package com.oaclinic.session;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

	private static Logger LOGGER = Logger.getLogger(SessionService.class);

	private static final int SESSION_TIMEOUT_MILLIS = 30 * 60 * 1000;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private Session session;

	public Session createSession(String userName) {
		if (sessionAlreadyExists(userName)) {
			LOGGER.error("Active session present for the user " + userName);
			throw new RuntimeException("User already logged in!");
		} else {
			session.setSessionId(UUID.randomUUID().toString());
			session.setUserName(userName);
			session.setTimeStamp(Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)));
			try {
				sessionRepository.save(session);
				return session;
			} catch (Exception e) {
				LOGGER.error("Failed to save session!");
				throw new RuntimeException(e);
			}
		}
	}

	public void validate(String sessionId) {
		Session session = sessionRepository.findBySessionId(sessionId);		
		if (Objects.nonNull(session)) {
			LOGGER.debug("Logged in at: " + session.getTimeStamp());
			long idleTime = getIdleTime(session);
			LOGGER.debug("Idle time in millis " + idleTime);
			if (sessionExpired(idleTime)) {
				removeExpiredSession(session);
				LOGGER.debug("Sessoin expired");
				throw new RuntimeException("Your session has expired!");
			} else {
				updateSessionWithLastAccessTime(session);
			}
		} else {
			LOGGER.debug("Sessoin not found");
			throw new RuntimeException("Invalid session id!");
		}
	}

	private void removeExpiredSession(Session session2) {
		sessionRepository.delete(session);
	}

	private void updateSessionWithLastAccessTime(Session session) {
		session.setTimeStamp(Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)));
		sessionRepository.save(session);
	}

	@SuppressWarnings("static-access")
	private long getIdleTime(Session session) {
		return Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)).getTime() - session.getTimeStamp().getTime();
	}

	private boolean sessionExpired(long timeEllapsed) {
		return timeEllapsed > SESSION_TIMEOUT_MILLIS;
	}

	public void invalidateSession(String userName, String sessionId) {
		Session session = sessionRepository.findBySessionId(sessionId);
		sessionRepository.delete(session);
	}

	private Boolean sessionAlreadyExists(String userName) {
		return Objects.nonNull(sessionRepository.findByUserName(userName));
	}

}
