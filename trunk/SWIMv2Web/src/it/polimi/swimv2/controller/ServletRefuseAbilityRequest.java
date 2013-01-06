package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilityRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityRequest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRefuseAbilityRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbilityRequest newAbilityBean = (IAbilityRequest) JNDILookupClass.doLookup("newAbilityBean");
		//gets information
		String stringNewAbility = request.getParameter("idNewAbility");
		int idNewAbility = Integer.parseInt(stringNewAbility);
		
		String idUserString = request.getParameter("idUser");
		int idUser = Integer.parseInt(idUserString);
		
		String name = request.getParameter("name");
		
		//creates AbilityRequest
		AbilityRequest newAbility = new AbilityRequest();
		newAbility.setIdNewAbility(idNewAbility);
		newAbility.setIdUser(idUser);
		newAbility.setName(name);
		
		//removes abilityRequest
		newAbilityBean.remove(newAbility);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/newAbilityRequests.jsp"); 
		rd.forward(request,response);
		
	}

}
