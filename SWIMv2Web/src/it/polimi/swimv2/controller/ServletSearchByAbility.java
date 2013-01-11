package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This class manages the search tab in the profile.jsp
public class ServletSearchByAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Call a session bean
		IAbility abilityBean = (IAbility) JNDILookupClass
				.doLookup("AbilityBean");

		// get the ability to search
		String abilityName = request.getParameter("search");
		List<Ability> abilities = abilityBean.findByName(abilityName);

		// Forward to a page that shows the results
		request.setAttribute("abilities", abilities);

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc
				.getRequestDispatcher("/searchByAbilityPage.jsp");
		rd.forward(request, response);

	}
}