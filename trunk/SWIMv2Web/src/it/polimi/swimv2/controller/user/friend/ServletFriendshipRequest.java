package it.polimi.swimv2.controller.user.friend;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Friendship;
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


public class ServletFriendshipRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Saving the ids of sender and requester
		int receiverId = Integer.parseInt(request.getParameter("userReceiverId"));
		int currentUserId = (int) request.getSession().getAttribute("id");
		int direction = Integer.parseInt(request.getParameter("direction"));
		
		// calling the Session Bean for entity FriendshipRequest and Friendship for suggestions
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		// creating the object FriendshipRequest setting the ids
		FriendshipRequest friendshipRequest = new FriendshipRequest();
		friendshipRequest.setReceiver(receiverId);
		friendshipRequest.setSender(currentUserId);
		friendshipRequest.setDirection(direction);
		
		if(receiverId==currentUserId){
			forward(request,response,"/messageFail.jsp");
		}else{
		
			// using bean methods to save the request in the database
			friendshipRequestBean.save(friendshipRequest);
		
			if( direction == 1){ // if the request is not direct, but it is suggested
				// forwarding to done.jsp page
				request.setAttribute("next", "ServletProfilePage");
				forward(request,response,"/messageDone.jsp");
			}else{
				//TODO forwarding to the friendship suggestion page
				//manage the info about friendship suggestion
				List<Friendship> friendshipList = friendshipBean.findByUserId(receiverId);
				List<User> listOfPossibleFriend = new ArrayList<User>();
			
				for(int i=0; i < friendshipList.size();i++){
					if(friendshipList.get(i).getUser1() == receiverId){
						listOfPossibleFriend.add(userBean.findUserById(friendshipList.get(i).getUser2()));
					}else{
						listOfPossibleFriend.add(userBean.findUserById(friendshipList.get(i).getUser1()));
					}
				}
				
				// set the list of suggested friends as an attribute in the request
				request.setAttribute("listOfPossibleFriends", listOfPossibleFriend);
				
				//forward to success page
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/friendshipSuggestionPage.jsp");
				rd.forward(request, response);	
				
			}
		
		}
		
	}
	
	// forward steps
		private void forward(HttpServletRequest request,
				HttpServletResponse response, String page) throws ServletException,
				IOException {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(page);
			rd.forward(request, response);
		}

}
