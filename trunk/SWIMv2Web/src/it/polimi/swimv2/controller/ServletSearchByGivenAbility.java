package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
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
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilityDeclaredBean");

		//get the ability to search
		int abilityId = Integer.parseInt(request.getParameter("id"));
				
		//get the id of users with that ability
		List<AbilityDeclared> usersIds = abilityDeclaredBean.findByAbilityId(abilityId);

		//get users 
		List<User> listOfUsersFound = new ArrayList<User>();

		for (int i=0;i < usersIds.size();i++){
			User found = userBean.findUserById(usersIds.get(i).getUser());
			listOfUsersFound.add(found);
		}		
		
		//removes from the list the user with the same session id
		for(int i=0; i < listOfUsersFound.size(); i++){
			if ((Integer) request.getSession().getAttribute("id") == listOfUsersFound.get(i).getId()){
				listOfUsersFound.remove(i);
			}
		}
		
		//Forward to a page that shows the results
		request.setAttribute("listOfUsers", listOfUsersFound);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/searchResultPage.jsp"); 
		rd.forward(request,response);
		
	}
}