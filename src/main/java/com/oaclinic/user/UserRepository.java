package com.oaclinic.user;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserNameAndUserPassword(String userName, String userPassword);

	public User findByUserName(String userName);
}
