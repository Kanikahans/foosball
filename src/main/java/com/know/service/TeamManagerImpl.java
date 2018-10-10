package com.know.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.know.dao.TeamDAO;
import com.know.dao.UserDAO;
import com.know.model.Team;
import com.know.model.User;

@Service("TeamManager")
public class TeamManagerImpl implements TeamManager {
	
	@Autowired
	private TeamDAO teamDAO;

	@Override
	public void saveTeam(Team team) {
		// TODO Auto-generated method stub
		teamDAO.saveTeam(team);
	}
	
	

	@Override
	public List<String> listAllTeams() {
		// TODO Auto-generated method stub
		return teamDAO.listTeams();
		//return null;
	}



	public TeamDAO getTeamDAO() {
		return teamDAO;
	}



	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

}
