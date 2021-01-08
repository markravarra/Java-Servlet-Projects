package com.messagingwebappv2.bean;

import java.util.Date;


public class Message {
	private Date dateAndTimeSent;
	private String message;
	private String senderName;
	
	public Message(Date dateAndTimeSent, String message, String senderName) {
		this.dateAndTimeSent = dateAndTimeSent;
		this.message = message;
		this.senderName = senderName;
	}

	public Date getDateAndTimeSent() {
		return dateAndTimeSent;
	}

	public String getMessage() {
		return message;
	}

	public String getSenderName() {
		return senderName;
	}
	
}
