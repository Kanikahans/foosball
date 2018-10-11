package com.know.service;

import java.util.List;

import com.know.model.Team;

public interface TeamManager {
	
	void saveTeam(Team team);
	
	List<String> listAllTeams();
	
	List<Team> showLeaderBoard();
}
