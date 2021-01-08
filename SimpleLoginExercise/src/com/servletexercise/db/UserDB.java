package com.servletexercise.db;

import java.util.ArrayList;
import java.util.List;

import com.servletexercise.bean.User;

public class UserDB {
	
	List<User> userList;
	
	public UserDB() {
		User user1 = new User("NarutoXD", "Naruto Uzumaki", "Kuramaisthebest");
		User user2 = new User("Lelouchness", "Lelouch Vermillion",  "codeGeass");
		User user3 = new User("Miggy", "Miggy Ravarra", "miggypwd");
		
		// Adding users to list;
		userList = new ArrayList<User>();
		addUser(user1);
		addUser(user2);
		addUser(user3);
	}

	public void addUser(User user) {
		userList.add(user);
	}
	
	public List<User> getUsers() {
		return userList;
	}

}
