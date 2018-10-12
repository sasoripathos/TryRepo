package com.jerry.icare;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
	
	@RequestMapping("/")
	public String showFirstPage() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		if(username.equals("admin")&& password.equals("12345")) {
			return "submit";
		} else {
			return "index";
		}
			
	}

}
