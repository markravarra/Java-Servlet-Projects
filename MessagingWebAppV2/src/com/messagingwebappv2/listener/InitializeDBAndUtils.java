package com.messagingwebappv2.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.messagingwebappv2.bean.User;
import com.messagingwebappv2.db.MessagesDB;
import com.messagingwebappv2.db.UserDB;

/**
 * Application Lifecycle Listener implementation class InitializeDB
 *
 */
@WebListener
public class InitializeDBAndUtils implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext sc = sce.getServletContext();
         UserDB userDB = new UserDB();
         System.out.println("User DB Created");
         List<User> onlineUsers = new ArrayList<User>();
         System.out.println("Online Users Created");
         MessagesDB messageBank = new MessagesDB();
         System.out.println("Messenger Database Created");
         sc.setAttribute("messagesDB", messageBank);
         sc.setAttribute("userDB", userDB);
         sc.setAttribute("onlineUsers", onlineUsers);
    }
	
}
