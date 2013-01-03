package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.INewAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.NewAbility;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAbilitiesServlet
 */
public class NewAbilitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		INewAbility newAbilityBean = (INewAbility) JNDILookupClass.doLookup("NewAbilityBean");
		
		List<NewAbility> newAbilityList = newAbilityBean.findAllNewAbilities();
		
		request.setAttribute("newAbilitiesList", newAbilityList);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/NewAbilityRequestsPage.jsp"); 
		rd.forward(request,response);
	}

}
