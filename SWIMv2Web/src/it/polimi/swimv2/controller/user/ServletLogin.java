package it.polimi.swimv2.controller.user;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IAdmin;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
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
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass
				.doLookup("AbilityDeclaredBean");

		// get login information from the request form sent by the login page
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// I use the Session Bean to check if the made user exist in the
		// database
		User user = userBean.findUserByLogin(email);

		// if login fail we control if it is an admin
		if (user == null||!(user.getPassword().equals(password))) {
			// checking the admin table
			Admin admin = adminBean.findAdminByLogin(email);
			if (admin == null||!(admin.getPassword().equals(password))) {
				String message = "Login Fail. You have probably insert uncorrect email or password";
				request.setAttribute("message", message);
				forward(request, response, "/messageFail.jsp");
				
			} else {
				// admin login successful
				HttpSession adminSession = request.getSession(true);
				int idAdmin = admin.getId();
				adminSession.setAttribute("id", idAdmin);

				request.setAttribute("admin", admin);
				forward(request, response, "/adminProfile.jsp");
			}
		}

		// if login is successful redirect to user page
		else {
			// creating a new Session with the user id
			HttpSession session = request.getSession(true);
			int id = user.getId();
			session.setAttribute("id", id);
			
			// build the list of user's abilities
			List<AbilityDeclared> abilities = abilityDeclaredBean
					.findByUserId(id);

			
			int idAbility;
			IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");

			
			List<String> names = new ArrayList<String>();
			List<Integer> posFeedbacks = new ArrayList<Integer>();
			List<Integer> negFeedbacks = new ArrayList<Integer>();
			
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
			
			// forward to the profile page
			request.setAttribute("user", user);
			forward(request, response, "/userProfile.jsp");
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
