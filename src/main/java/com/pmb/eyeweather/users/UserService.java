package com.pmb.eyeweather.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao database;

	public User getUser(String username, String password){
		User user = database.getUser(username, password);
		return user;
	}

	public List<User> findAllEnabledUser() {
		List<User> result = database.findAllEnabledUsers();
		return result;
	}
}
