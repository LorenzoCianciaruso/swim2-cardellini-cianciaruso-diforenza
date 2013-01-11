package it.polimi.swimv2.controller.user.friend;

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


public class ServletSearchAmongFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userToSearch = request.getParameter("userToSearch");
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		//Call a session bean
		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");
		IFriendship friendshipBean = (IFriendship) JNDILookupClass.doLookup("FriendshipBean");
		
		//find all friendships of the user
		List<Friendship> listOfFriendship = friendshipBean.findByUserId(currentUserId);
		
		// building list of User of friends
		List<User> listOfFriendUser = new ArrayList<User>();
		for(int i=0; i<listOfFriendship.size(); i++){
			if(currentUserId == listOfFriendship.get(i).getUser2()){
				listOfFriendUser.add(bean.findUserById(listOfFriendship.get(i).getUser1()));
			}else
				listOfFriendUser.add(bean.findUserById(listOfFriendship.get(i).getUser2()));
		}
		
		for(int i=listOfFriendUser.size()-1; i >= 0; i--){
			if( !(listOfFriendUser.get(i).getName().equals(userToSearch)) ){
				listOfFriendUser.remove(i);
			}
		}
		
		//Forward to a page that shows the results
		request.setAttribute("listOfUsers", listOfFriendUser);
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/searchResultPage.jsp"); 
		rd.forward(request,response);
	}

}
