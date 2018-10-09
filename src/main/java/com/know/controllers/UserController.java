package com.know.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.know.dao.UserDAO;
import com.know.dao.UserDAOImpl;
import com.know.model.User;
import com.know.service.UserManager;

@Controller
public class UserController {
	
	
	@Autowired
	private UserManager userManager;
	
	
	
	public void setUserManager(UserManager userManager)
	{
		this.userManager=userManager;
		
	}
	
	
	public UserManager getuserManager()
	{
		return userManager;
	}
	@GetMapping("/")
	public String showIndexPage(ModelMap model)
	{
		System.out.println("yooooooooooooooooooooooooooooooooooo");
		return "index";
	}
	
	@GetMapping("/registerUser")
	public String registerUser(ModelMap model)
	{
		System.out.println("inside Register User");
		return "registerUser";
	}

	@PostMapping("/registerUser")
	public ModelAndView UserRegisteration(User user,ModelAndView model)
	{
		System.out.println("method post requesstttt");
		System.out.println(user.getFirstName());
		System.out.println("userDAO" + userManager);
		userManager.saveUser(user);
		//userDAO.print();
		
		//userDAO.saveUser(user);
		System.out.println("user added successfully");
		
		//model.addAttribute("firstName", user.getFirstName());
		//model.addAttribute("lastName", user.getFirstName());
		//model.addAttribute("userName", user.getFirstName());
		model.addObject("user", user);
		//model.addAttribute("user", user);
		//System.out.println("inside Register User");
		return model;
	}
}
