package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAbilityDeleted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] toDelete = request
				.getParameterValues("abilityDeleted");

		int currentUserId = (int) request.getSession().getAttribute("id");

		IAbilityDeclared abilitiesDeclaredBean = (IAbilityDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");
	
		for (int i = 0; i < toDelete.length; i++) {
			abilitiesDeclaredBean.remove(Integer.parseInt(toDelete[i]),currentUserId);

		}
		
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletSkillPage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);
	}

}
