package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.Ability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletAbilityDeleted extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] abilityToDeleteStringArray =  request.getParameterValues("abilityDeleted");
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		
		List<AbilitiesDeclared> listDeclared = abilitiesDeclaredBean.findAbilitiesOwnedByUserId(currentUserId);
		
		Ability a;
		for(int i=0; i<listDeclared.size(); i++){
			
			a = abilityBean.searchById(listDeclared.get(i).getAbility());
			
			for(int j=0; j<abilityToDeleteStringArray.length; j++){

				System.out.println("DEBUG-a.getName(): "+a.getName());
				System.out.println("DEBUG-abilityToDeleteStringArray[j]: "+abilityToDeleteStringArray[j]);
				if(a.getName().equals(abilityToDeleteStringArray[j])){
					abilitiesDeclaredBean.remove(listDeclared.get(i));
				}
			}
		}
		
		ServletContext sc = getServletContext(); 
		RequestDispatcher rd = sc.getRequestDispatcher("/done.jsp"); 
		rd.forward(request,response);
	}

}
