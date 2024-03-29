package it.polimi.swimv2.controller.user.ability;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
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

		// receive the name of declared abilities
		String[] abilitiesList = request.getParameterValues("ability");

		IAbilityDeclared abilityDeclaredBean = (IAbilityDeclared) JNDILookupClass
				.doLookup("AbilityDeclaredBean");
		IAbility abilityBean = (IAbility) JNDILookupClass
				.doLookup("AbilityBean");
		// get user id
		int userId = (int) request.getSession().getAttribute("id");

		// for each ability create an entity ability declared
		for (int i = 0; i < abilitiesList.length; i++) {
			Ability a = abilityBean.findById(Integer.parseInt(abilitiesList[i]));
			AbilityDeclared abDec = new AbilityDeclared();
			abDec.setAbility(a.getId());
			abDec.setUser(userId);
			abDec.setPositiveFeedback(DEFAULT_FEEDBACK);
			abilityDeclaredBean.save(abDec);
		}
		// forward to success page
		ServletContext sc = getServletContext();
		request.setAttribute("next", "ServletSkillPage");
		RequestDispatcher rd = sc.getRequestDispatcher("/messageDone.jsp");
		rd.forward(request, response);

	}

}
