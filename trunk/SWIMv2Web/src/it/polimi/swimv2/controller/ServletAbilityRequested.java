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

public class ServletAbilityRequested extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newAbilityString = request.getParameter("abilityAdded");		
		INewAbility newAbilityBean = (INewAbility) JNDILookupClass.doLookup("NewAbilityBean");
		
		List<NewAbility> list = newAbilityBean.findAllNewAbilities();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName() == newAbilityString){
				response.sendRedirect(response.encodeRedirectURL("done.jsp"));
			}
		}
		
		NewAbility newAbility = new NewAbility();
		newAbility.setName(newAbilityString);
		newAbility.setIdUser((int)request.getSession().getAttribute("id"));
		
		newAbilityBean.save(newAbility);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/done.jsp"); 
		rd.forward(request,response);
		
	}

}
