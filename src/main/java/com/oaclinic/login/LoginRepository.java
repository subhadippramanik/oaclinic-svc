package com.oaclinic.login;

import org.springframework.data.repository.CrudRepository;

     interface LoginRepository extends CrudRepository<Login, Integer>{
	 public Login findOneByUserNmaeNPassword(String userName, String password);
}
