package it.polimi.swimv2.controller;

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

public class ServletAdminDeleteAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilityDeclaredBean");
		
		//receives the id of the ability to delete
		String string = request.getParameter("abilityId");
		int id = Integer.parseInt(string);

		// removes the ability from Ability table
		abilityBean.remove(id);

		//searches all the tuples with that ability declared
		List<AbilityDeclared> list = new ArrayList<AbilityDeclared>();
		list = abilityDeclaredBean.findByAbilityId(id);
		
		// removes all tuples with that ability in AbilitiesDeclared table
		for (int i = 0; i < list.size(); i++) {
			abilityDeclaredBean.remove(list.get(i).getId());
		}

		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletAdminAbilityList");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	}

}
