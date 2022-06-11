package com.ty.school.service;

import com.ty.school.dao.UserDao;
import com.ty.school.dto.User;

public class UserService {

	public User saveUser(User user) {
		UserDao dao = new UserDao();
		return dao.saveUser(user);		
	}

	public void deleteUser(User user) {

	}
	
	public boolean validateUser(String email, String pwd) {
		UserDao dao = new UserDao();
		return dao.validateUser(email, pwd);
	}
}
