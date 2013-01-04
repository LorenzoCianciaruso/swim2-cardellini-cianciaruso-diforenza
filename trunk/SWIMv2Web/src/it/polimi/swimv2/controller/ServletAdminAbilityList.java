package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAdminAbilityList
 */
public class ServletAdminAbilityList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean"); 
		
		List<Ability> abilityList = abilityBean.findAllAbilities();
		
		request.setAttribute("abilityList", abilityList);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/adminAbilityList.jsp"); 
		rd.forward(request,response);
	}

}
