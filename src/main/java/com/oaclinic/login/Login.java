package com.oaclinic.login;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private int UserId; 
	private String FullName;
	private String UserName; 
	private String UserPwd;
	private String UserRole;
	private String IsActive;
	private String TemplatePath;
	
	public Login() {
		super();
	}

	public Login(int userId, String fullName, String userName, String userPwd, String userRole, String isActive,
			String templatePath) {
		super();
		UserId = userId;
		FullName = fullName;
		UserName = userName;
		UserPwd = userPwd;
		UserRole = userRole;
		IsActive = isActive;
		TemplatePath = templatePath;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public String getTemplatePath() {
		return TemplatePath;
	}

	public void setTemplatePath(String templatePath) {
		TemplatePath = templatePath;
	}
	
	
}
