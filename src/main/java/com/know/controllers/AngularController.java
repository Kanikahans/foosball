package com.know.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.know.service.UserManager;

@RestController
public class AngularController {
	
	@Autowired
	private UserManager userManager;
	
	
	public UserManager getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	@GetMapping("/rest/getPlayer")
	public String getPlayer()
	{
		Gson gson = new Gson();
		JSONObject json = new JSONObject();
		try {
			json.put("userRules", gson.toJson(userManager.listAllUsers()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
				
				}

}
