package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.User;

import java.io.IOException;
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

		int id = Integer.parseInt(request.getParameter("userId"));
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbilitiesDeclared abilityBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		User user = new User();
		user.setId(id);

		// i look for a user that has the same id in the database
		User currentUser = userBean.findUserById(id);
		request.setAttribute("user", currentUser);

		// build the list of user's abilities
		List <AbilitiesDeclared> abilities = abilityBean.findAbilitiesOwnedByUserId(id);
		request.setAttribute("abilities", abilities);
		
		// forward to the profile page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc
				.getRequestDispatcher("/profileSeenByOtherPage.jsp");
		rd.forward(request, response);

	}
}
