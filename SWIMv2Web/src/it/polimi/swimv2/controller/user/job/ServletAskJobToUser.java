package it.polimi.swimv2.controller.user.job;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAskJobToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilityDeclaredBean");
		
		//get the user that will perform the job and his abilities
		int idPerformer = Integer.parseInt(request.getParameter("userPerformerId"));
				
		// build the list of user's abilities
				List<AbilityDeclared> abilities = abilityDeclaredBean
						.findByUserId(idPerformer);

				List<String> names = new ArrayList<String>();
				List<Integer> idAbilities = new ArrayList<Integer>();
				int idAbility;
				IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");

				for (int i = 0; i < abilities.size(); i++) {
					// build the list that contains abilities id
					idAbility = abilities.get(i).getAbility();
					idAbilities.add(idAbility);
					// build the list that contains abilities name
					names.add(abilityBean.findById(idAbility).getName());					
				}
				request.setAttribute("names", names);				
				request.setAttribute("idAbilities", idAbilities);
				
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/userNewJobRequest.jsp"); 
				rd.forward(request,response);
	}
}
