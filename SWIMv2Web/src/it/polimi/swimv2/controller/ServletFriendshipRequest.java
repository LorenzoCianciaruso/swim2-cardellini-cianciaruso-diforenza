package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.FriendshipRequest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFriendshipRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Saving the ids of sender and requester
		int receiverId = Integer.parseInt(request.getParameter("userReceiverId"));
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		// calling the Session Bean for entity FriendshipRequest
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		
		// creating the object FriendshipRequest setting the ids
		FriendshipRequest friendshipRequest = new FriendshipRequest();
		friendshipRequest.setReceiver(receiverId);
		friendshipRequest.setSender(currentUserId);
		
		// using bean methods to save the request in the database
		friendshipRequestBean.save(friendshipRequest);
			
		// forwarding to done.jsp page
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp"); 
		rd.forward(request,response);
		
	}

}
