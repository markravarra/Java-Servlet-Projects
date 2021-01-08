package com.messagingwebappv2.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCreated
 *
 */
@WebListener
public class SessionCreated implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
