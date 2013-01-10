package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.IAbilityRequest;
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
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilityRequest abilityRequestBean = (IAbilityRequest) JNDILookupClass.doLookup("AbilityRequestBean");
		
		String name = request.getParameter("name");
		
		Ability ab = new Ability();
		ab.setName(name);
		
		//saves the new ability
		abilityBean.saveAbility(ab);
		
		
		String idString = request.getParameter("idNewAbility");
		int id = Integer.parseInt(idString);
		
		//removes the abilityRequest
		abilityRequestBean.remove(id);
		
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletAcceptAbilityRequest");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);	
		
		
	}

}
