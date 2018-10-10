package com.know.dao;

import java.util.List;

import com.know.model.Team;
import com.know.model.User;

public interface TeamDAO {
	
	public void saveTeam(Team team);
	
	public List<String> listTeams();

}
