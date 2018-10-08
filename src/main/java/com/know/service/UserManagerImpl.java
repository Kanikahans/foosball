package com.know.service;

import org.springframework.stereotype.Service;

import com.know.dao.UserDAO;
import com.know.model.User;

@Service("UserManager")
public class UserManagerImpl implements UserManager {
	
	private UserDAO userDAO;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user);
	}
	
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO=userDAO;
		
	}
	public UserDAO getUserDAO()
	{
		return userDAO;
	}

}
