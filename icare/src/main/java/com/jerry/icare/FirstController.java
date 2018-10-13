package com.jerry.icare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FirstController {
	
	@Autowired
	private UserRepository repo;
	
	private User user;

	@RequestMapping("/")
	public String showFirstPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "index";
	}
	
	/*@PostMapping("/login")
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
	}*/	
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, @ModelAttribute("loginUser") User loginUser,
			RedirectAttributes red) {
		String email = loginUser.getEmail();
		this.user = repo.findByEmail(email);
		
		if(user != null && user.getEmail().equals(email) && user.getPassword().equals(loginUser.getPassword())) {
			HttpSession session = request.getSession(false);
			session.setAttribute("user", email);
			session.setMaxInactiveInterval(30);
			System.out.println("session-id: " + session.getId());
			System.out.println("session-user: " + session.getAttribute("user"));
			//red.addFlashAttribute("loginUser", user);
			return "redirect:/submit";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/submit")
	public String submitPage(HttpServletRequest request, Model model) {
		HttpSession session = LoginChecker.isLogin(request);
		if(session == null) {
			System.out.println("session has timeout");
			return "redirect:/";
		}
		model.addAttribute("loginUser", this.user);
		return "submit";
	}
	
	@RequestMapping("/report")
	public String reportPage(HttpServletRequest request, Model model) {
		HttpSession session = LoginChecker.isLogin(request);
		if(session == null) {
			System.out.println("session has timeout");
			return "redirect:/";
		}
		model.addAttribute("loginUser", this.user);
		return "report";
	}
	
	@PostMapping("/submission")
	public String fileSubmission() {
		return "redirect:/report";
	}
	
	@PostMapping("/back")
	public String backToSubmit() {
		return "redirect:/submit";
	}

}
