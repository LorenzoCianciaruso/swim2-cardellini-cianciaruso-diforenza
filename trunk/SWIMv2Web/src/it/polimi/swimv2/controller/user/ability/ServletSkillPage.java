package it.polimi.swimv2.controller.user.ability;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.clientutility.JNDILookupClass;
import it.polimi.swimv2.entities.AbilityDeclared;
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

public class ServletSkillPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilityDeclared abilitiesDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilityDeclaredBean");
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		
		List<AbilityDeclared> abilitiesDeclaredOwned = abilitiesDeclaredBean.findByUserId(currentUserId);
		
		List<Ability> abilitiesOwned = new ArrayList<Ability>();
		
		for(int i=0; i< abilitiesDeclaredOwned.size(); i++){						
			abilitiesOwned.add(abilityBean.findById(abilitiesDeclaredOwned.get(i).getAbility()));
		}
		
		List<Ability> abilitiesList = abilityBean.allAbilities();
		abilitiesList.removeAll(abilitiesOwned);
			
		request.setAttribute("abilitiesOwned", abilitiesOwned);
		request.setAttribute("abilitiesList", abilitiesList);
			
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userAbilitiesManager.jsp"); 
		rd.forward(request,response);
	}
}

