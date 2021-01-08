package com.messagingwebappv2.db;

import java.util.HashMap;
import java.util.Stack;

import com.messagingwebappv2.bean.Message;

public class MessagesDB {
	HashMap<String, Stack<Message>> messagesBank;

	public MessagesDB() {
		messagesBank = new HashMap<String, Stack<Message>>();
	}

	public void storeMessages(String sender, Stack<Message> messageStack) {
		messagesBank.put(sender, messageStack);
	}

	public Stack<Message> getMessages(String sender) {
		return messagesBank.get(sender);
	}
	
	public void removeMessages(String userID) {
		messagesBank.remove(userID);
	}
	
	public boolean checkUserInMessagesBank(String userName) {
		return messagesBank.containsKey(userName);
	}
}
