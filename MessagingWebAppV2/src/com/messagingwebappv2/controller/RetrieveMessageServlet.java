package com.messagingwebappv2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messagingwebappv2.bean.Message;
import com.messagingwebappv2.bean.User;
import com.messagingwebappv2.db.MessagesDB;
import com.messagingwebappv2.utils.MessengerUtil;

/**
 * Servlet implementation class RetrieveMessageServlet
 */
@WebServlet("/retrievemessage")
public class RetrieveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MessagesDB messagesDB = (MessagesDB) getServletContext().getAttribute("messagesDB");

		List<User> onlineUsers = (List<User>) getServletContext().getAttribute("onlineUsers");
		User user = (User) session.getAttribute("user");

		Stack<Message> messageStack = messagesDB.getMessages(user.getUserName());

		if (messageStack != null) {
			List messageList = new ArrayList(messageStack);
			request.setAttribute("messages", messageList);
		} else {
			request.setAttribute("info", "Nobody has sent you a message yet!");
		}
		request.getRequestDispatcher("/WEB-INF/view/messaging/RetrieveMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
