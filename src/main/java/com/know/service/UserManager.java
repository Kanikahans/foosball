package com.know.service;

import java.util.List;

import com.know.model.User;

public interface UserManager {
	
	void saveUser(User user);
	
	List<String> listAllUsers();
	

}
