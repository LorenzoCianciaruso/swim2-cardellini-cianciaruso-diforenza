package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;


import java.awt.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDeleteAbility
 */
public class ServletAdminDeleteAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO elimina abilit� dal database 
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("abilitiesDeclaredBean");
		
		/*String string = request.getParameter("abilityId");
		int id = Integer.parseInt(string);
		*/
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/adminAbilityList.jsp"); 
		rd.forward(request,response);
	}

}