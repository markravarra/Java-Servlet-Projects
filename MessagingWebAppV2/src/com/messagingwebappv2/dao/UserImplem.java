package com.messagingwebappv2.dao;

import java.util.List;

import com.messagingwebappv2.bean.User;
import com.messagingwebappv2.db.UserDB;

public class UserImplem {

	UserDB userDB;

	public UserImplem(UserDB userDB) {
		this.userDB = userDB;
	}

	private List<User> getUser() {
		return userDB.getUsers();
	}

	public User getUserByID(String userID) {
		User userOfID = null;
		for (User user : getUser()) {
			if (user.getUserID().equals(userID)) {
				userOfID = user;
				break;
			}
		}
		return userOfID;
	}
	
	public User getUserByName(String userName) {
		User userOfName = null;
		for (User user : getUser()) {
			if (user.getUserName().equals(userName)) {
				userOfName = user;
				break;
			}
		}
		return userOfName;
	}

	public User findUser(String userID, String password) {
		User checkUser = getUserByID(userID);

		if (checkUser.getPassword().equals(password))
			return checkUser;
		else
			return null;

	}

	public boolean isExistingUserByID(String userID) {
		return getUserByID(userID) != null;
	}
	
	public boolean isExistingUserByName(String userName) {
		return getUserByName(userName) != null;
	}
}
