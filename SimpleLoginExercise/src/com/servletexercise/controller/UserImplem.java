package com.servletexercise.controller;

import java.util.List;

import com.servletexercise.bean.User;
import com.servletexercise.db.UserDB;

public class UserImplem {

	UserDB userDB;

	public UserImplem() {
		userDB = new UserDB();
	}

	public List<User> getUser() {
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
}
