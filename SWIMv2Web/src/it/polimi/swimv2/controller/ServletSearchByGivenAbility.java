package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
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

//This class manages the search tab in the profile.jsp
public class ServletSearchByGivenAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Call a session bean
		IUser userBean = (IUser) JNDILookupClass.doLookup("UserBean");
		IAbilitiesDeclared abilityDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");

		//get the ability to search
		int abilityId = Integer.parseInt(request.getParameter("id"));
				
		//get the id of users with that ability
		List<AbilitiesDeclared> usersIds = abilityDeclaredBean.searchByAbilityId(abilityId);

		//get users 
		List<User> listOfUsersFound = new ArrayList<User>();

		for (int i=0;i<usersIds.size();i++){
			User found = userBean.findUserById(usersIds.get(i).getUser());
			listOfUsersFound.add(found);
		}		
		
		//Forward to a page that shows the results
		request.setAttribute("listOfUsers", listOfUsersFound);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/searchResultPage.jsp"); 
		rd.forward(request,response);
		
	}
}