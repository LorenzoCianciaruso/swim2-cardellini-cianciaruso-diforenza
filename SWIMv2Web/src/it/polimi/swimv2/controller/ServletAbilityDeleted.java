package it.polimi.swimv2.controller;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.business.INewAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.Ability;
import it.polimi.swimv2.entities.NewAbility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletAbilityDeleted extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String abilityToDeleteString = request.getParameter("abilityDeleted");
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		
		List<AbilitiesDeclared> listDeclared = abilitiesDeclaredBean.findAbilitiesOwnedByUserId(currentUserId);
		
		List<Ability> listOfAbilities = new ArrayList<Ability>();
		Ability a;
		for(int i=0; i<listDeclared.size(); i++){
			
			a = abilityBean.searchById(listDeclared.get(i).getAbility());
			
			if(a.getName() == abilityToDeleteString){
				abilitiesDeclaredBean.remove(listDeclared.get(i));
			}
		}
	}

}
