package it.polimi.swimv2.businesslogic;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(mappedName="AbilitiesDeclared")
@Remote(IAbilitiesDeclared.class)
public class AbilitiesDeclaredBean implements IAbilitiesDeclared {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public AbilitiesDeclaredBean() {}

	@Override
	public void saveAbilityDeclared(int idAbility, int userId) {
		// TODO Auto-generated method stub
		
	}
    
    

}
