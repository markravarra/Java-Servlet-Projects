package com.messagingwebappv2.utils;

import java.util.List;

import com.messagingwebappv2.bean.User;

public class MessengerUtil {
	
	public static User inOnlineList(List<User> onlineUsers, String recipient) {
		for(User user : onlineUsers) {
			if(user.getUserName().equals(recipient)) {
				return user;
			}
		}
		return null;
	}
	
	public static User getSender(List<User> onlineUsers, String senderID) {
		for(User user : onlineUsers) {
			if(user.getUserID().equals(senderID)) {
				return user;
			}
		}
		return null;
	}
}
