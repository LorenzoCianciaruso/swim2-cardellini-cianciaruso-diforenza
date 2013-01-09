package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.FriendshipRequest;
import it.polimi.swimv2.entities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletFriendshipPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		List<FriendshipRequest> requestsToMe = friendshipRequestBean.findFriendshipRequestByPerformer(currentUserId);
		List<FriendshipRequest> requestsByMe = friendshipRequestBean.findFriendshipRequestByRequestor(currentUserId);
		request.setAttribute("requestsToMe", requestsToMe);
		request.setAttribute("requestsByMe", requestsByMe);
		
		//create the lists of users names
		List<User> userIAsked = new ArrayList<User>();
		List<User> userAskedToMe =  new ArrayList<User>();
			
		int requestorId;
		for (int i = 0; i < requestsToMe.size(); i++) {
				
			requestorId = requestsToMe.get(i).getSender();
			userAskedToMe.add(userBean.findUserById(requestorId));
		}
				
		int performerId;
		for (int i = 0; i < requestsByMe.size(); i++) {
				
			performerId = requestsByMe.get(i).getReceiver();
			userIAsked.add(userBean.findUserById(performerId));
		}
				
		request.setAttribute("userIAsked", userIAsked);
		request.setAttribute("userAskedToMe", userAskedToMe);
			
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userFriendshipRequestsManager.jsp"); 
		rd.forward(request,response);
	}

}
