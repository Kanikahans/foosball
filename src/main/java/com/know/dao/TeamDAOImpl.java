package com.know.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.know.model.Team;
import com.know.model.User;

@Repository("TeamDAO")
public class TeamDAOImpl extends JdbcDaoSupport implements TeamDAO {
	
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
	public void saveTeam(Team team) {
		System.out.println("In team DAO save user method" );
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println();
		String sql="Insert into team (team_name,player1,player2) values (?,?,?)";
		getJdbcTemplate().update(sql, team.getTeamName(),team.getPlayer1(),team.getPlayer2());
		
		
		
	}
	
	@Override
	public List<String> listTeams()
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println();
		String sql="Select team_name from team";
		return getJdbcTemplate().queryForList(sql,String.class);
	}
	
	public void print()
	{
		System.out.println("Calling DAIIIIIIIIII");
	}

}
