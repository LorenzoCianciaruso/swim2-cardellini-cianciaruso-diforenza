package it.polimi.swimv2.businesslogic;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.entities.AbilitiesDeclared;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(mappedName="AbilitiesDeclaredBean")
@Remote(IAbilitiesDeclared.class)
public class AbilitiesDeclaredBean implements IAbilitiesDeclared {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public AbilitiesDeclaredBean() {}

	@Override
	public void saveAbilityDeclared(AbilitiesDeclared abDec) {
		entityManager.persist(abDec);
		
	}
    
    

}
