package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;

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
		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");
		User user = new User();
		user.setId(id);

		// i look for a user that has the same id in the database
		User currentUser = bean.findUserById(user);

		
			// i build the request form with user parameter
			request.setAttribute("user", currentUser);

			// forward to the profile page
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc
					.getRequestDispatcher("/profileSeenByOtherPage.jsp");
			rd.forward(request, response);
		}
	}

