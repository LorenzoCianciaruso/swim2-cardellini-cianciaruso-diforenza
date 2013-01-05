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


public class ServletAbilityAdded extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] abilitiesList = request.getParameterValues("ability");
		
		IAbilitiesDeclared bean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		
		int userId = (int) request.getSession().getAttribute("id");
		
		for(int i=0; i< abilitiesList.length ; i++){
			
			Ability a = abilityBean.findByName(abilitiesList[i]);
			
			AbilitiesDeclared abDec = new AbilitiesDeclared();
			
			abDec.setAbility(a.getIdAbility());
			abDec.setUser(userId);
			abDec.setFeedback(0);
			bean.saveAbilityDeclared(abDec);
		}
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/done.jsp"); 
		rd.forward(request,response);
		
	}

}
