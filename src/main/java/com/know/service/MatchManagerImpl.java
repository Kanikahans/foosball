package com.know.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.know.dao.MatchDAO;
import com.know.dao.TeamDAO;
import com.know.dao.UserDAO;
import com.know.model.Match;
import com.know.model.Team;
import com.know.model.User;

@Service("MatchManager")
public class MatchManagerImpl implements MatchManager {
	
	@Autowired
	private MatchDAO matchDAO;


	public MatchDAO getMatchDAO() {
		return matchDAO;
	}



	public void setMatchDAO(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}



	@Override
	public void saveMatchResult(Match match) {
		// TODO Auto-generated method stub
		matchDAO.saveResult(match);
		
	}





}
