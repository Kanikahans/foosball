package com.know.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.know.dao.UserDAO;
import com.know.dao.UserDAOImpl;
import com.know.model.Match;
import com.know.model.Team;
import com.know.model.User;
import com.know.service.TeamManager;
import com.know.service.UserManager;

@Controller
public class UserController {

	@Autowired
	private UserManager userManager;

	@Autowired
	private TeamManager teamManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;

	}

	public UserManager getuserManager() {
		return userManager;
	}

	@GetMapping("/")
	public String showIndexPage(ModelMap model) {
		System.out.println("yooooooooooooooooooooooooooooooooooo");
		return "index";
	}

	@GetMapping("/registerUser")
	public String registerUser(ModelMap model) {
		System.out.println("inside Register User");
		return "registerUser";
	}

	@PostMapping("/registerUser")
	public ModelAndView UserRegisteration(User user, ModelAndView model) {
		System.out.println("method post requesstttt");
		System.out.println(user.getFirstName());
		System.out.println("userDAO" + userManager);
		userManager.saveUser(user);
		// userDAO.print();

		// userDAO.saveUser(user);
		System.out.println("user added successfully");

		// model.addAttribute("firstName", user.getFirstName());
		// model.addAttribute("lastName", user.getFirstName());
		// model.addAttribute("userName", user.getFirstName());
		model.addObject("user", user);
		// model.addAttribute("user", user);
		// System.out.println("inside Register User");
		return model;
	}

	@GetMapping("/registerTeam")
	public ModelAndView getAllUsers() {

		System.out.println("inside Register Team");
		Team team = new Team();
		// List<String> userList=userManager.listAllUsers();
		
		ModelAndView modelAndView =new ModelAndView("registerTeam", "Team", team);
				//new ModelAndView("registerTeam", team) ;
				//new ModelAndView("registerTeam", "command", team);
		return modelAndView;
	}

	@ModelAttribute("player1")
	public List<String> getplayerList() {
		return userManager.listAllUsers();
	}

	@ModelAttribute("player2")
	public List<String> getplayrList() {
		return userManager.listAllUsers();
	}

	@PostMapping("/registerTeam")
	public ModelAndView TeamRegisteration(Team team, ModelAndView model) {
		System.out.println("method post requesstttt");
		System.out.println(team.getTeamName());
		teamManager.saveTeam(team);
		// userDAO.print();

		// userDAO.saveUser(user);
		System.out.println("user added successfully");

		// model.addAttribute("firstName", user.getFirstName());
		// model.addAttribute("lastName", user.getFirstName());
		// model.addAttribute("userName", user.getFirstName());
		model.addObject("Team", team);
		// model.addAttribute("user", user);
		// System.out.println("inside Register User");
		return model;
	}
	
	
	@GetMapping("/playMatch")
	public ModelAndView getAllTeams() {

		System.out.println("inside Register Team");
		Match match = new Match();
		// List<String> userList=userManager.listAllUsers();
		
		ModelAndView modelAndView =new ModelAndView("playMatch", "Match", match);
				//new ModelAndView("registerTeam", team) ;
				//new ModelAndView("registerTeam", "command", team);
		return modelAndView;
	}

	@ModelAttribute("teamA")
	public List<String> getTeamList() {
		return teamManager.listAllTeams();
	}

	@ModelAttribute("teamB")
	public List<String> getTeammList() {
		return teamManager.listAllTeams();
	}

	@PostMapping("/playMatch")
	public ModelAndView playMatch(Match match, ModelAndView model) {
		System.out.println("method post requesstttt");
		//System.out.println(team.getTeamName());
		//teamManager.saveTeam(team);
		// userDAO.print();

		// userDAO.saveUser(user);
		System.out.println("user added successfully");

		// model.addAttribute("firstName", user.getFirstName());
		// model.addAttribute("lastName", user.getFirstName());
		// model.addAttribute("userName", user.getFirstName());
		//model.addObject("Team", team);
		// model.addAttribute("user", user);
		// System.out.println("inside Register User");
		return model;
	}

	public TeamManager getTeamManager() {
		return teamManager;
	}

	public void setTeamManager(TeamManager teamManager) {
		this.teamManager = teamManager;
	}

}
