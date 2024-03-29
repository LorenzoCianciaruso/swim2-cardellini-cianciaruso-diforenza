package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This class manages the search tab in the profile.jsp
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Call a session bean
		IUser bean = (IUser) JNDILookupClass.doLookup("UserBean");
		
		//get info from request
		String searchName = request.getParameter("search");
		
		//call Bean's method to find an user using the name
		List<User> listOfUsersFound = bean.findUserByName(searchName);
		
		//removes from the list the user with the same session id (not an admin and not a guest)
		if ((Integer) request.getSession().getAttribute("id")!=null ){
		for(int i=0; i< listOfUsersFound.size();i++){
			if ((Integer) request.getSession().getAttribute("id") == listOfUsersFound.get(i).getId()){
				listOfUsersFound.remove(i);
			}
		}
		}
		
		//Forward to a page that shows the results
		request.setAttribute("listOfUsers", listOfUsersFound);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/searchResultPage.jsp"); 
		rd.forward(request,response);
		
	}

}
