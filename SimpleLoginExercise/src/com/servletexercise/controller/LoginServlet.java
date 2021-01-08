package com.servletexercise.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletexercise.bean.User;

@WebServlet(description = "LoginServlet", urlPatterns = { "/LoginServlet" })

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserImplem userImplem;

	public void init() throws ServletException {
		userImplem = new UserImplem();
		if (getServletContext().getInitParameter("dbURL").equals("jdbc:mysql://localhost/mysql_db")
				&& getServletContext().getInitParameter("dbUser").equals("mysql_user")
				&& getServletContext().getInitParameter("dbUserPwd").equals("mysql_pwd")) {
			getServletContext().setAttribute("DB_Success", "True");
		} else
			throw new ServletException("DB COnnection error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// take request parameters for userID and password
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		User currentUser = userImplem.getUserByID(userID);
		
		PrintWriter out = response.getWriter();
		
//		if(currentUser != null)
		if(userImplem.getUser().contains(currentUser)) {
			if(currentUser.getPassword().equals(password)) {
				request.setAttribute("user", currentUser);
				RequestDispatcher view = getServletContext().getRequestDispatcher("/LoginSuccess");
				view.forward(request, response);
			} else {
				RequestDispatcher view = getServletContext().getRequestDispatcher("/login.html");
				out.println("<font color=red>Password Incorrect, please try again.</font>");
				view.include(request, response);
			}
		} else {
			RequestDispatcher view = getServletContext().getRequestDispatcher("/login.html");
			out.println("<font color=red>User does not exist</font>");
			view.include(request, response);
		}
		
	}

}
