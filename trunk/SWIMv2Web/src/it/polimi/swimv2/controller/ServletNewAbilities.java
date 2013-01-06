package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilityRequest;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityRequest;

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
public class ServletNewAbilities extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbilityRequest newAbilityBean = (IAbilityRequest) JNDILookupClass.doLookup("NewAbilityBean");
		
		List<AbilityRequest> newAbilityList = newAbilityBean.findAllAbilityRequests();
		
		request.setAttribute("newAbilitiesList", newAbilityList);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/newAbilityRequests.jsp"); 
		rd.forward(request,response);
	}

}
