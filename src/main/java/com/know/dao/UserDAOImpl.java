package com.know.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.know.model.User;

@Repository("UserDAO")
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	
	/*@Autowired*/
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	
	 /*@Autowired
	 public void setUserDAOImpl(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }*/
	 
	 //public void getJdbc
	
	/*public UserDAOImpl(DataSource dataSource)
	{
		
		jdbcTemplate =new JdbcTemplate(dataSource);
	}*/
	

	@Override
	public void saveUser(User user) {
		System.out.println("In user DAO save user method" );
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println();
		String sql="Insert into player (first_name,last_name,username) values (?,?,?)";
		getJdbcTemplate().update(sql, user.getFirstName(),user.getLastName(),user.getUserName());
		
		
		
	}
	
	public void print()
	{
		System.out.println("Calling DAIIIIIIIIII");
	}

}
