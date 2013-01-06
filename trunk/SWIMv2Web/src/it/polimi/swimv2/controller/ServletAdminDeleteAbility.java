package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;


import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

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
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("abilitiesDeclaredBean");
		
		String string = request.getParameter("abilityId");
		int id = Integer.parseInt(string);
		
		//rimuove abilità dalla tabella abilità
		abilityBean.deleteAbilityById(id);
		
		
		//rimuove abilità da tabella abilitiesdeclared
		List<AbilitiesDeclared> list = new ArrayList<AbilitiesDeclared>(); 
		list = abilitiesDeclaredBean.searchAbilitiesDeclaredById(id);
		
		for(int i=0; i < list.size();i++){
			abilitiesDeclaredBean.remove(list.get(i));
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/adminAbilityList.jsp"); 
		rd.forward(request,response);
	}

}
