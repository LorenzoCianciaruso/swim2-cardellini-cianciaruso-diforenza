package it.polimi.swimv2.controller;

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
		// TODO Auto-generated method stub
		// stampo a video tutte le abilit� della tabella Ability del Database in una pagina jsp
		// con delle checkbox da spuntare. In fondo all'elenco ci sar� un pulsante "Update"
		// che chiama un servlet che controlla le abilit� selezionate e aggiorna le tabelle opportune
		// sotto ci sar� un campo di testo dove l'utente propone una nuova abilit� non ancora presente
		// nell'elenco, con un pulsante "send" che aggiunge tale abilit� nella tbella NewAbility
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilityDeclared abilitiesDeclaredBean = (IAbilityDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		AbilityDeclared abDec = new AbilityDeclared();
		abDec.setUser(currentUserId);
		
		List<AbilityDeclared> abilitiesDeclaredOwned = abilitiesDeclaredBean.findByUserId(currentUserId);
		
		List<Ability> abilitiesOwned = new ArrayList<Ability>();
		
		for(int i=0; i< abilitiesDeclaredOwned.size(); i++){
						
			abilitiesOwned.add(abilityBean.findById(abilitiesDeclaredOwned.get(i).getAbility()));
		}
		
		List<Ability> abilitiesList = abilityBean.allAbilities();
			
		request.setAttribute("abilitiesOwned", abilitiesOwned);
		request.setAttribute("abilitiesList", abilitiesList);
			
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userAbilitiesManager.jsp"); 
		rd.forward(request,response);
	}
}

