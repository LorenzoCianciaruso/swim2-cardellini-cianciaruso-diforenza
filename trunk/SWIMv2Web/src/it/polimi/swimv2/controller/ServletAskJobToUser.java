package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;

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
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		
		//get the user that will perform the job and his abilities
		int idPerformer = Integer.parseInt(request.getParameter("userPerformerId"));
				
		// build the list of user's abilities
				List<AbilitiesDeclared> abilities = abilitiesDeclaredBean
						.findAbilitiesOwnedByUserId(idPerformer);

				List<String> names = new ArrayList<String>();
				List<Integer> feedbacks = new ArrayList<Integer>();
				List<Integer> idAbilities = new ArrayList<Integer>();
				int idAbility;
				IAbility abilityBean = (IAbility) JNDILookupClass
						.doLookup("AbilityBean");

				for (int i = 0; i < abilities.size(); i++) {
					// build the list that contains abilities id
					idAbility = abilities.get(i).getAbility();
					idAbilities.add(idAbility);
					// build the list that contains abilities name
					names.add(abilityBean.searchById(idAbility).getName());
					// build the list that contains abilities feedback
					feedbacks.add(abilities.get(i).getFeedback());
					idAbilities.add(idAbility);

					
				}
				request.setAttribute("names", names);
				request.setAttribute("feedbacks", feedbacks);
				request.setAttribute("idAbilities", idAbilities);
				
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/userNewJobRequest.jsp"); 
				rd.forward(request,response);
	}
}
