package com.messagingwebappv2.controller;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/sendmessage")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			request.getRequestDispatcher("/WEB-INF/view/messaging/SendMessage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/error/AccessDenied.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		// Get recipient and messageContent
		String recipient = request.getParameter("recipient");
		String messageContent = request.getParameter("messageContent");
		
		List<User> onlineUsers = (List<User>) getServletContext().getAttribute("onlineUsers");
		User sender = (User) session.getAttribute("user");
		
		MessagesDB messageBank = (MessagesDB) getServletContext().getAttribute("messagesDB");
		System.out.println(messageBank);
		
		Date currentTime = new Date();
		
		if(MessengerUtil.inOnlineList(onlineUsers, recipient) != null) {
//			if(messageBank.getMessages(recipient) != null) {
//				messageBank.getMessages(recipient)
//				.push(new Message(currentTime, messageContent, sender.getUserName()));
//				request.setAttribute("sendError", "");
//				request.setAttribute("successMessage", "Message Successfully sent");
//				doGet(request, response);
//			} else {
//				System.out.println("creating new message stack");
//				messageBank.storeMessages(recipient, new Stack<Message>());
//				messageBank.getMessages(recipient)
//				.push(new Message(currentTime, messageContent, sender.getUserName()));
//				request.setAttribute("sendError", "");
//				request.setAttribute("successMessage", "Message Successfully sent");
//				doGet(request, response);
//			}
			if(!messageBank.checkUserInMessagesBank(recipient)) {
				messageBank.storeMessages(recipient, new Stack<Message>());
			}
			
			messageBank.getMessages(recipient)
			.push(new Message(currentTime, messageContent, sender.getUserName()));
			request.setAttribute("sendError", "");
			request.setAttribute("successMessage", "Message Successfully sent");
			doGet(request, response);
		} else {
			String errorMessage = "Unable to send message. The user is either not logged in or not existing.";
			request.setAttribute("successMessage", "");
			request.setAttribute("sendError", errorMessage);
			doGet(request, response);
		}
	}

}
