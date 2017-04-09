package com.example.services;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.common.util.ServiceCalls;
import com.jayway.restassured.response.Response;
import com.userdata.dataobject.ServiceController;
import com.userdata.pojo.User;

@RestController

public class Userdataservice {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String adduser(@RequestBody String payload) {

		System.out.println(payload);
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(payload);
			User user = new User();
			user.setName(json.get("name").toString());
			user.setAddress(json.get("address").toString());
			user.setCity(json.get("city").toString());
			user.setState(json.get("state").toString());
			user.setZip(json.get("zip").toString());
			user.setEmail(json.get("email").toString());
			user.setPhone(json.get("phone").toString());
			// Inserting into database

			ServiceController sc = new ServiceController();
			sc.insertUser(user);

		} catch (Exception ex) {
			ex.printStackTrace();

			return "Input Error";
		}
		return "Success";
	}
	
	@RequestMapping(value="/greet",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Hello from service";
	}
	
	@RequestMapping(value="/getusers",method=RequestMethod.GET)
	public List<User> getUsers()
	{
		List<User> usersList = null;
		
		ServiceController sc = new ServiceController();
		
		usersList = sc.getUsers();
		
		return usersList;
		
	}

	
	@RequestMapping(value="/ustory",method=RequestMethod.POST)
	public String getUserStory(@RequestBody String payload)
	{
		String c1="/getusers"; //get
		String c2="/add"; //post
		String c3="/greet"; //get
		String responseC1="URL = /getusers";
		String responseC2="URL = /add";
		String responseC3="URL = /greet";
		
		
		ServiceCalls sc = new ServiceCalls();
		try
		{
		
		 // C1	
		 Response  resp = sc.goGet(c1);
		 responseC1=responseC1+resp.asString();
		 
		 //C2
		 Response respc2 = sc.goPost(c2,payload);
		 
		 responseC2 = responseC2+respc2.asString();
		 
		 //C3
		 
		 Response  respC3 = sc.goGet(c3);
		 responseC3=responseC3+respC3.asString();
		 
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return responseC1+"\n"+responseC2+"\n"+responseC3;
	}
}
