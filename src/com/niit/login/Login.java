package com.niit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.company.HotelDB;


@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("password");
		int result = HotelDB.Login(uname, pass);
		if (result != -1) {
			// Good log in 
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);   
			response.sendRedirect("home.jsp"); 
			com.company.Access.loggedIn = 1;
		} else { 
			// Bad login
			response.sendRedirect("MainLogin.jsp");
		} 
	} 
}
  