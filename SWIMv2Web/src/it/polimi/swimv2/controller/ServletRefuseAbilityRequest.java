package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.INewAbility;
import it.polimi.swimv2.businesslogic.NewAbilityBean;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.NewAbility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRefuseAbilityRequest
 */
public class ServletRefuseAbilityRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		INewAbility newAbilityBean = (INewAbility) JNDILookupClass.doLookup("newAbilityBean");
		
		String stringNewAbility = request.getParameter("idNewAbility");
		int idNewAbility = Integer.parseInt(stringNewAbility);
		
		String idUserString = request.getParameter("idUser");
		int idUser = Integer.parseInt(idUserString);
		
		String name = request.getParameter("name");
		
		NewAbility newAbility = new NewAbility();
		newAbility.setIdNewAbility(idNewAbility);
		newAbility.setIdUser(idUser);
		newAbility.setName(name);
		
		newAbilityBean.remove(newAbility);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/newAbilityRequests.jsp"); 
		rd.forward(request,response);
		
	}

}
