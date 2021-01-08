package com.messagingwebappv2.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messagingwebappv2.bean.User;
import com.messagingwebappv2.dao.UserImplem;
import com.messagingwebappv2.db.UserDB;

@WebServlet(description = "LoginServlet", urlPatterns = { "/login" })

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
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
		String ipAddress = request.getRemoteAddr();
		
		UserDB userDB = (UserDB) getServletContext().getAttribute("userDB");
		UserImplem userImplem = new UserImplem(userDB);
		List<User> onlineUsers = (List<User>) getServletContext().getAttribute("onlineUsers");
		
		User currentUser = null;
		String errorMessage = "";
		
		if(userImplem.isExistingUserByID(userID)) {
			currentUser = userImplem.findUser(userID, password);
			if(currentUser != null) {
				HttpSession session = request.getSession();
				currentUser.goOnline();
				onlineUsers.add(currentUser);
				
				session.setAttribute("user", currentUser);
				session.setAttribute("userName", currentUser.getUserName());
				session.setAttribute("ipAddress", ipAddress);
				session.setAttribute("loginDateTime", new Date());
				System.out.println(session.getId());
				
				response.sendRedirect("home");
			} else {
				errorMessage = "Password Incorrect! Please Try Again.";
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("userID", userID);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} else {
			errorMessage = "User Does not Exist!";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
}
