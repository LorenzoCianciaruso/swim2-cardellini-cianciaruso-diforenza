package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Friendship;
import it.polimi.swimv2.entities.FriendshipRequest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFriendshipAccepted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idFriendshipRequest"));
		
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");
		
		//get the request to accept
		FriendshipRequest req = friendshipRequestBean.findFriendshipRequestById(id);
		
		//create new job
		Friendship fs = new Friendship();
		
		fs.setidUser1(req.getReceiver());
		fs.setidUser2(req.getSender());
				
		friendshipBean.saveFriendship(fs);
		
		//delete the friendship request from the db
		friendshipRequestBean.remove(id);
		
		//manage the info about friendship suggestion
		
		
		//forward to success page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/friendshipSuggestionPage.jsp");
		rd.forward(request, response);	
	}

}
