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

public class ServletFriendshipAccepted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		int idFriendshipRequest = Integer.parseInt(request.getParameter("idFriendshipRequest"));
		
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		//get the request to accept
		FriendshipRequest req = friendshipRequestBean.findById(idFriendshipRequest);
		
		//create new job
		Friendship fs = new Friendship();
		
		fs.setUser1(req.getReceiver());
		fs.setUser2(req.getSender());
				
		friendshipBean.save(fs);
		
		//delete the friendship request from the db
		friendshipRequestBean.remove(idFriendshipRequest);
		
		//manage the info about friendship suggestion
		List<Friendship> friendshipList = friendshipBean.findByUserId(userId);
		List<User> listOfPossibleFriend = new ArrayList<User>();
		
		for(int i=0; i < friendshipList.size();i++){
			if(friendshipList.get(i).getUser1() == userId){
				listOfPossibleFriend.add(userBean.findUserById(friendshipList.get(i).getUser2()));
			}else{
				listOfPossibleFriend.add(userBean.findUserById(friendshipList.get(i).getUser1()));
			}
		}
		
		//removes from the list the user with the same session id
		for(int i=0; i < listOfPossibleFriend.size(); i++){
			if ((Integer) request.getSession().getAttribute("id") == listOfPossibleFriend.get(i).getId()){
				listOfPossibleFriend.remove(i);
			}
		}
		
		request.setAttribute("listOfPossibleFriends", listOfPossibleFriend);
		
		//forward to success page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/friendshipSuggestionPage.jsp");
		rd.forward(request, response);	
	}

}
