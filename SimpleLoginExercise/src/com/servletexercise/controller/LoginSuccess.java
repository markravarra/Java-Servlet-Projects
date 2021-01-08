package com.servletexercise.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletexercise.bean.User;

@WebServlet(description = "LoginSuccess", urlPatterns = { "/LoginSuccess" })
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START = "<html><body>";
	public static final String HTML_END = "</body></html>";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		User user = (User) request.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		out.println(HTML_START
				+ "<center>"
				+ "<h2>LOGIN STATUS:</h2>"
				+ "<h3><p style=\"color:green;\">Login Successful! Welcome " +user.getUserName()+ "</p></h3>"
				+ "<a href=\"login.html\">Logout</a>"
				+ "</center>"
				+ HTML_END);
	}

}
