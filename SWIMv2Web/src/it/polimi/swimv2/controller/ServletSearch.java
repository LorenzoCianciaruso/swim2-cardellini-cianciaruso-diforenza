package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDIUserLookupClass;
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
		IUser bean = JNDIUserLookupClass.doLookup();
		
		//get info from request
		String searchName = request.getParameter("search");
		
		//create a user with that name
		User userToSearch = new User();
		userToSearch.setName(searchName);
		
		//call Bean's method to find an user using the name
		List<User> listOfUsersFound = bean.findUserByName(userToSearch);
		
		//Forward to a page that shows the results
		request.setAttribute("listOfUsers", listOfUsersFound);
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/SearchResultPage.jsp"); 
		rd.forward(request,response);
		
	}

}
