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
import javax.servlet.http.HttpSession;

public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUser bean = JNDILookupClass.doLookup();
		
		String searchName = request.getParameter("search");
		
		User userToSearch = new User();
		userToSearch.setName(searchName);
		
		List<User> listOfUsersFound = bean.findUserByName(userToSearch);
		
		request.setAttribute("listOfUsers", listOfUsersFound);
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/SearchResultPage.jsp"); 
		rd.forward(request,response);
		
	}

}
