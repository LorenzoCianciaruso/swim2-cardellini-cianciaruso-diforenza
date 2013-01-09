package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IAdmin;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.Admin;
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
import javax.servlet.http.HttpSession;

//manage login from the Homepage
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAdmin adminBean = (IAdmin) JNDILookupClass.doLookup("AdminBean");
		IAbilitiesDeclared abilityDeclaredBean = (IAbilitiesDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");

		// get login information from the request form sent by the login page
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// make a new user with those email and password
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);

		// make a new admin
		Admin a = new Admin();
		a.setEmail(email);
		a.setPassword(password);

		// I use the Session Bean to check if the made user exist in the
		// database
		User u2 = userBean.findUserByLogin(u);

		// if login fail we control if it is an admin
		if (u2 == null) {
			// checking the admin table
			Admin a2 = adminBean.findAdminByLogin(a);
			if (a2 == null) {
				String message = "Login Fail. You have probably insert uncorrect email or password";
				request.setAttribute("message", message);
				forward(request, response, "/loginFail.jsp");
				//response.sendRedirect(response
						//.encodeRedirectURL("loginFail.jsp"));
			} else {
				// admin login successful
				HttpSession adminSession = request.getSession(true);
				
				adminSession.setAttribute("id", 0);

				request.setAttribute("admin", a2);
				forward(request, response, "/adminProfile.jsp");
			}
		}

		// if login is successful redirect to user page
		else {
			// creating a new Session with the user id
			HttpSession session = request.getSession(true);
			int id = u2.getId();
			session.setAttribute("id", id);
			
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
			
			// forward to the profile page
			request.setAttribute("user", u2);
			forward(request, response, "/profile.jsp");
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
