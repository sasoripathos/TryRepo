package com.jerry.spring_graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jerry.graph.User;

@RestController
@RequestMapping("/test")
public class SampleRest {
	private static int cnt = 0;
	private static List<User> users = new ArrayList<User>();
	
	@GetMapping("/newuser")
	public User getNewUser() {
		SampleRest.cnt ++;
		User newUser = new User(SampleRest.cnt);
		SampleRest.users.add(newUser);
		return newUser;
	}
	
	@GetMapping("/test")
	public String test(){
		return "return";
	}

}
