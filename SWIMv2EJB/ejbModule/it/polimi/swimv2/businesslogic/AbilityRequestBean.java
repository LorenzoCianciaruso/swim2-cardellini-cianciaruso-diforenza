package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IAbilityRequest;
import it.polimi.swimv2.entities.AbilityRequest;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="NewAbilityBean")
@Remote(IAbilityRequest.class)
public class AbilityRequestBean implements IAbilityRequest {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public AbilityRequestBean() {}

	@Override
	public List<AbilityRequest> findAllNewAbilities() {
		// TODO Auto-generated method stub
		String q = "SELECT a FROM NewAbility a";
		Query query = entityManager.createQuery(q);
		try{
			List<AbilityRequest> newAbilitiesList = (List<AbilityRequest>) query.getResultList();
			return newAbilitiesList;
			
		}catch (NoResultException e){
			return null;
		}
	}

	@Override
	public void save(AbilityRequest newAbility) {
		entityManager.persist(newAbility);
	}	

	@Override
	public void remove(AbilityRequest newAbility){
		entityManager.remove(newAbility);
	}
		
	
}
