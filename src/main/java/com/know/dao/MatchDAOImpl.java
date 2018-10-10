package com.know.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.know.model.Match;
import com.know.model.Team;
import com.know.model.User;

@Repository("MatchDAO")
public class MatchDAOImpl extends JdbcDaoSupport implements MatchDAO {
	
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
	public void saveResult(Match match) {
		System.out.println("In team DAO save user method" );
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println();
		String sql="Insert into matchs (teamA,teamB,winningTeam) values (?,?,?)";
		String sql2="Update team set team_score= where team_name=?";
		String sql3="Update team set team_score= where team_name=?";
		getJdbcTemplate().update(sql,match.getTeamA(),match.getTeamB(),match.getWinningTeam() );
		getJdbcTemplate().update(sql2,match.getWinningTeam() );
		//getJdbcTemplate().update(sql3,match.getTeamA(),match.getTeamB(),match.getWinningTeam() );
		
		
		
	}

}
