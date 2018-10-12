package com.jerry.icare;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginChecker {
	public static HttpSession isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			return null;
		} else {
			return session;
		}
	}

}
