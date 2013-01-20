package it.polimi.swimv2.controller.user;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
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

public class ServletProfileSeenByOther extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// receive the id corresponding to the profile to see
		int id = Integer.parseInt(request.getParameter("userId"));
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass
				.doLookup("AbilityDeclaredBean");
		IFriendship friendshipBean = (IFriendship) JNDILookupClass
				.doLookup("FriendshipBean");
		IFriendshipRequest friendshipRequestBean = (IFriendshipRequest) JNDILookupClass.doLookup("FriendshipRequestBean");

		// i look for a user that has the same id in the database
		User userToShow = userBean.findUserById(id);
		request.setAttribute("user", userToShow);

		// build the list of user's abilities
		List<AbilityDeclared> abilities = abilityDeclaredBean
				.findByUserId(id);

		List<String> names = new ArrayList<String>();
		List<Integer> posFeedbacks = new ArrayList<Integer>();
		List<Integer> negFeedbacks = new ArrayList<Integer>();
		int idAbility;
		IAbility abilityBean = (IAbility) JNDILookupClass
				.doLookup("AbilityBean");

		for (int i = 0; i < abilities.size(); i++) {
			// build the list that contains abilities name
			idAbility = abilities.get(i).getAbility();
			names.add(abilityBean.findById(idAbility).getName());
			// build the list that contains abilities feedback
			posFeedbacks.add(abilities.get(i).getPositiveFeedback());
			negFeedbacks.add(abilities.get(i).getNegativeFeedback());
		}

		request.setAttribute("names", names);
		request.setAttribute("posFeedbacks", posFeedbacks);
		request.setAttribute("negFeedbacks", negFeedbacks);

		// in case of a friendship request, we need to know if it is direct or suggested
		request.setAttribute("direction", request.getParameter("direction"));

		if ((Integer) request.getSession().getAttribute("id") == null) {
			forward(request, response, "/profileSeenByGuest.jsp");		
		}else if((Integer) request.getSession().getAttribute("id") == 0) {
			forward(request, response, "/profileSeenByAdmin.jsp");
		} else if((Integer) request.getSession().getAttribute("id") > 0){

			// ho commentato perchè lanciava un ecc
			// check if this user is already my friend
			int currentUserId = (int) request.getSession().getAttribute("id");
			if (friendshipBean.isFriend(currentUserId, id) || friendshipRequestBean.isRequestPending(currentUserId, id)) {
				request.setAttribute("isFriend", 1);
			} else {
				request.setAttribute("isFriend", 0);
			}

		// forward to the profile page
		forward(request, response, "/profileSeenByOther.jsp");
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
