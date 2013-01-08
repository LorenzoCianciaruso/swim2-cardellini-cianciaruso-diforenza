package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Friendship;
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


public class ServletFriendListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// IDEA: se mettiamo un campo di ricerca qui dentro facciamo la ricerca solo tra gli amici
		// utilizzando lo stesso codice della ricerca normale, cambia sol la query
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		// list of all friendship of the current user
		List<Friendship> friendshipList = friendshipBean.findAllFriendshipsByUserId(currentUserId);

		// build a list of user from the list of friendship
		List<User> friendList = new ArrayList<User>();
		for(int i=0; i<friendshipList.size(); i++){
			
			if(friendshipList.get(i).getidUser1() == currentUserId){
				friendList.add(userBean.findUserById(friendshipList.get(i).getidUser2()));
			}else
				friendList.add(userBean.findUserById(friendshipList.get(i).getidUser1()));
		}

		request.setAttribute("friendList", friendList);
		
		//forward to jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/friendListPage.jsp"); 
		rd.forward(request,response);
	}

}
