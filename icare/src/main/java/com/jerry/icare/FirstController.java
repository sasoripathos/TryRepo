package com.jerry.icare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@RequestMapping("/")
	public String showFirstPage() {
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		if(username.equals("admin")&& password.equals("12345")) {
			HttpSession session = request.getSession(false);
			session.setAttribute("user", username);
			session.setMaxInactiveInterval(30);
			System.out.println("session-id: " + session.getId());
			System.out.println("session-user: " + session.getAttribute("user"));
			return new ModelAndView("redirect:/submit");
		} else {
			return new ModelAndView("redirect:/");
		}	
	}
	
	@RequestMapping("/submit")
	public String submitPage(HttpServletRequest request) {
		HttpSession session = LoginChecker.isLogin(request);
		if(session == null) {
			System.out.println("session has timeout");
			return "redirect:/";
		}
		return "submit";
	}
	
	@RequestMapping("/report")
	public String reportPage(HttpServletRequest request) {
		HttpSession session = LoginChecker.isLogin(request);
		if(session == null) {
			System.out.println("session has timeout");
			return "redirect:/";
		}
		return "report";
	}
	
	@PostMapping("/submission")
	public ModelAndView fileSubmission() {
		return new ModelAndView("redirect:/report");
	}
	
	@PostMapping("/back")
	public ModelAndView backToSubmit() {
		return new ModelAndView("redirect:/submit");
	}

}
