package com.messagingwebappv2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messagingwebappv2.bean.User;
import com.messagingwebappv2.db.MessagesDB;
import com.messagingwebappv2.utils.MessengerUtil;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userID = request.getParameter("userID");
		System.out.println(userID);
		List<User> onlineUsers = (List<User>) getServletContext().getAttribute("onlineUsers");
		User user = MessengerUtil.getSender(onlineUsers, userID);
        String logoutFeedBack = request.getParameter("logoutFeedBack");
        
        System.out.println(logoutFeedBack);
        HttpSession session = request.getSession();
        MessagesDB messageBank = (MessagesDB) session.getAttribute("messagesDB");
        
        if(logoutFeedBack.equals("YES")) {
        	user.goOffline();
        	onlineUsers.remove(user);
        	messageBank.removeMessages(userID);
        	response.sendRedirect(request.getContextPath() + "/Login.jsp");
        } else {
        	response.sendRedirect(request.getContextPath() + "/home?userID=" + userID);
        }
        
	}

}
