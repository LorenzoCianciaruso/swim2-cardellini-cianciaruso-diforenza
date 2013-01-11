package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
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
		IAbilitiesDeclared abilityDeclaredBean = (IAbilitiesDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");
		IFriendship friendshipBean = (IFriendship) JNDILookupClass
				.doLookup("FriendshipBean");

		// i look for a user that has the same id in the database
		User userToShow = userBean.findUserById(id);
		request.setAttribute("user", userToShow);

		// build the list of user's abilities
		List<AbilitiesDeclared> abilities = abilityDeclaredBean
				.searchByUserId(id);

		List<String> names = new ArrayList<String>();
		List<Integer> feedbacks = new ArrayList<Integer>();
		int idAbility;
		IAbility abilityBean = (IAbility) JNDILookupClass
				.doLookup("AbilityBean");

		for (int i = 0; i < abilities.size(); i++) {
			// build the list that contains abilities name
			idAbility = abilities.get(i).getAbility();
			names.add(abilityBean.searchById(idAbility).getName());
			// build the list that contains abilities feedback
			feedbacks.add(abilities.get(i).getFeedback());
		}

		request.setAttribute("names", names);
		request.setAttribute("feedbacks", feedbacks);

		if ((Integer) request.getSession().getAttribute("id") == 0) {
			forward(request, response, "/profileSeenByAdmin.jsp");
		} else {

			// ho commentato perchè lanciava un ecc
			// check if this user is already my friend
			int currentUserId = (int) request.getSession().getAttribute("id");
			if (friendshipBean.isFriend(currentUserId, id)) {
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
