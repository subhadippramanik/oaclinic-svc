package com.oaclinic.session;

import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer>{

	Session findById(String sessionId);

	Session findBySessionId(String sessionId);

	Session findByUserName(String userName);
	
}
