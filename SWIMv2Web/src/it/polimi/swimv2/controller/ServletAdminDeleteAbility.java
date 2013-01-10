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

public class ServletAdminDeleteAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		
		//receives the id of the ability to delete
		String string = request.getParameter("abilityId");
		int id = Integer.parseInt(string);

		// removes the ability from Ability table
		abilityBean.deleteAbilityById(id);

		//searches all the tuples with that ability declared
		List<AbilitiesDeclared> list = new ArrayList<AbilitiesDeclared>();
		list = abilitiesDeclaredBean.searchAbilitiesDeclaredByIdAbility(id);
		
		// removes all tuples with that ability in AbilitiesDeclared table
		for (int i = 0; i < list.size(); i++) {
			abilitiesDeclaredBean.remove(list.get(i).getId());
		}

		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletAdminAbilityList");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	}

}
