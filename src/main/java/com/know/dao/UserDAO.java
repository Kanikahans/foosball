package com.know.dao;

import java.util.List;

import com.know.model.User;

public interface UserDAO {
	
	public void saveUser(User user);
	
	public List<String> listUsers();

}
