package it.polimi.swimv2.controller.user.ability;

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

public class ServletAbilityRequested extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newAbilityString = request.getParameter("abilityAdded");		
		IAbilityRequest newAbilityBean = (IAbilityRequest) JNDILookupClass.doLookup("AbilityRequestBean");
		
		List<AbilityRequest> list = newAbilityBean.allAbilityRequests();
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName() == newAbilityString){
				response.sendRedirect(response.encodeRedirectURL("messageDone.jsp"));
			}
		}
		
		AbilityRequest newAbility = new AbilityRequest();
		newAbility.setName(newAbilityString);
		newAbility.setUser((int)request.getSession().getAttribute("id"));
		
		newAbilityBean.save(newAbility);
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp"); 
		rd.forward(request,response);
		
	}

}
