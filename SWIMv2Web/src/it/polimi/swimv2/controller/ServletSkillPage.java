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

public class ServletSkillPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// stampo a video tutte le abilità della tabella Ability del Database in una pagina jsp
		// con delle checkbox da spuntare. In fondo all'elenco ci sarà un pulsante "Update"
		// che chiama un servlet che controlla le abilità selezionate e aggiorna le tabelle opportune
		// sotto ci sarà un campo di testo dove l'utente propone una nuova abilità non ancora presente
		// nell'elenco, con un pulsante "send" che aggiunge tale abilità nella tbella NewAbility
		
		IAbility abilityBean = (IAbility) JNDILookupClass.doLookup("AbilityBean");
		IAbilitiesDeclared abilitiesDeclaredBean = (IAbilitiesDeclared) JNDILookupClass.doLookup("AbilitiesDeclaredBean");
		
		int currentUserId = (int) request.getSession().getAttribute("id");
		AbilitiesDeclared abDec = new AbilitiesDeclared();
		abDec.setUser(currentUserId);
		
		List<AbilitiesDeclared> abilitiesDeclaredOwned = abilitiesDeclaredBean.findAbilitiesOwnedByUserId(currentUserId);
		
		List<Ability> abilitiesOwned = new ArrayList<Ability>();
		
		for(int i=0; i< abilitiesDeclaredOwned.size(); i++){
						
			abilitiesOwned.add(abilityBean.searchById(abilitiesDeclaredOwned.get(i).getAbility()));
		}
		
		List<Ability> abilitiesList = abilityBean.findAllAbilities();
			
		request.setAttribute("abilitiesOwned", abilitiesOwned);
		request.setAttribute("abilitiesList", abilitiesList);
			
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/userAbilitiesManager.jsp"); 
		rd.forward(request,response);
	}
}

