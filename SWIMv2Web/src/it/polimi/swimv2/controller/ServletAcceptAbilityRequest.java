package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAcceptAbilityRequest
 */
public class ServletAcceptAbilityRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("abilityBean");
		
		String name = request.getParameter("name");
		
		Ability ab = new Ability();
		ab.setName(name);
		
		//saves the new ability
		abilityBean.saveAbility(ab);
		
		//TODO sarebbe da reindirizzare alla stessa pagina passando attraverso ServletNewAbilities
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/adminProfile");
		rd.forward(request, response);	
		
		
	}

}
