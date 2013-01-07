package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
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

		//receive the id corresponding to the profile to see
		int id = Integer.parseInt(request.getParameter("userId"));
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbilitiesDeclared abilityDeclaredBean = (IAbilitiesDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");
		
		// i look for a user that has the same id in the database
		User userToShow = userBean.findUserById(id);
		request.setAttribute("user", userToShow);

		// build the list of user's abilities
		List<AbilitiesDeclared> abilities = abilityDeclaredBean
				.findAbilitiesOwnedByUserId(id);

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
		request.setAttribute("abilities", abilities);

		// forward to the profile page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc
				.getRequestDispatcher("/profileSeenByOtherPage.jsp");
		rd.forward(request, response);

	}
}
