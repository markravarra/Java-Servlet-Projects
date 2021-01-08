package com.messagingwebappv2.bean;

public class User {
	private String userID;
	private String userName;
	private String password;
	private boolean isOnline = false;

	public String getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean isOnline() {
		return isOnline;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void goOnline() {
		isOnline = true;
	}
	
	public void goOffline() {
		isOnline = false;
	}
}
