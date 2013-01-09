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

//manage the access to the profile.jsp page checking the session id
public class ServletProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");

		// retrieve the session id
		int id = (Integer) request.getSession().getAttribute("id");
		IAbilitiesDeclared abilityDeclaredBean = (IAbilitiesDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");

		if (id == 0) {
			forward(request, response, "/adminProfile.jsp");
		} else {

			// i look for a user that has the same id in the database
			User user = bean.findUserById(id);

			if (user == null) {
				// redirect to the fail page
				response.sendRedirect(response
						.encodeRedirectURL("messageFail.jsp"));
			} else {
				// i build the request form with user parameter
				request.setAttribute("user", user);

				// build the list of user's abilities
				List<AbilitiesDeclared> abilities = abilityDeclaredBean
						.findAbilitiesOwnedByUserId(user.getId());

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

				// forward to the profile page
				forward(request, response, "/userProfile.jsp");

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
