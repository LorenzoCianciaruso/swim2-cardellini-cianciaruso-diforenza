package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IAbility;
import it.polimi.swimv2.entities.Ability;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="AbilityBean")
@Remote(IAbility.class)
public class AbilityBean implements IAbility {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public AbilityBean() {}

	@Override
	public List<Ability> findAllAbilities() {
		// TODO Auto-generated method stub
		String q = "SELECT a FROM Ability a";
		Query query = entityManager.createQuery(q);
		try{
			List<Ability> abilitiesList = (List<Ability>) query.getResultList();
			return abilitiesList;
			
		}catch (NoResultException e){
			return null;
		}
	}

	@Override
	public Ability findByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
    
 
}
