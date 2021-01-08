package com.messagingwebappv2.db;

import java.util.ArrayList;
import java.util.List;

import com.messagingwebappv2.bean.User;

public class UserDB {
	
	List<User> userList;
	
	public UserDB() {
		User user1 = new User();
		user1.setUserID("NarutoXD");
		user1.setUserName("Naruto Uzumaki");
		user1.setPassword("KuramaNamba1");
		
		User user2 = new User();
		user2.setUserID("Miggy");
		user2.setUserName("Miggy Ravarra");
		user2.setPassword("miggypwd");
		
		// Adding users to list;
		userList = new ArrayList<User>();
		addUser(user1);
		addUser(user2);
	}

	public void addUser(User user) {
		userList.add(user);
	}
	
	public List<User> getUsers() {
		return userList;
	}

}
