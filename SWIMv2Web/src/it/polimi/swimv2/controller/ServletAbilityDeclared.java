package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletAbilityDeclared extends HttpServlet {
	private static final int DEFAULT_FEEDBACK = 0;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//receive the name of declared abilities
		String[] abilitiesList = request.getParameterValues("ability");

		IAbilitiesDeclared bean = (IAbilitiesDeclared) JNDILookupClass
				.doLookup("AbilitiesDeclaredBean");
		IAbility abilityBean = (IAbility) JNDILookupClass
				.doLookup("AbilityBean");
		//get user id
		int userId = (int) request.getSession().getAttribute("id");
		
		//for eacch ability create an entity ability declared
		for (int i = 0; i < abilitiesList.length; i++) {
			Ability a = abilityBean.findByName(abilitiesList[i]);
			AbilitiesDeclared abDec = new AbilitiesDeclared();
			abDec.setAbility(a.getIdAbility());
			abDec.setUser(userId);
			abDec.setFeedback(DEFAULT_FEEDBACK);
			bean.saveAbilityDeclared(abDec);
		}
		//forward to success page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);

	}

}