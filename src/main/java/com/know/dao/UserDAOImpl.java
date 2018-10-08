package com.know.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.know.model.User;

public class UserDAOImpl implements UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DataSource dataSource)
	{
		jdbcTemplate =new JdbcTemplate(dataSource);
	}

	@Override
	public void saveUser(User user) {
		System.out.println("In user DAO save user method");
		// TODO Auto-generated method stub
		String sql="Insert into player (first_name,last_name,username) values (?,?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(),user.getUserName());
		
		
		
	}
	
	public void print()
	{
		System.out.println("Calling DAIIIIIIIIII");
	}

}
