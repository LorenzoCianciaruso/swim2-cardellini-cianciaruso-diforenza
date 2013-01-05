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

//This class manages the access to the profile.jsp page, checking the Session id
public class ServletProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		//I check which user id matches the session
		//i save the session id
		int currentSessionId = (Integer) request.getSession().getAttribute("id");
		
		//i make a new user with the session id
		User user = new User();
		user.setId(currentSessionId);
		
		//i look for a user that has the same id in the database
		User currentUser = bean.findUserById(currentSessionId);
		
		if(currentUser == null){
			//redirect to the fail page
			response.sendRedirect(response.encodeRedirectURL("loginFail.jsp"));
		}else{
			//i build the request form with user parameter
			request.setAttribute("user", currentUser);
			
			//forward to the profile page
			ServletContext sc = getServletContext(); 
			RequestDispatcher rd = sc.getRequestDispatcher("/profile.jsp"); 
			rd.forward(request,response);
			
		}
		
		
	}

}
