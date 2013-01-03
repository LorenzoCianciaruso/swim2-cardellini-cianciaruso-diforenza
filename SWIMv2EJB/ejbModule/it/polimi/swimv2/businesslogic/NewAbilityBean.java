package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.INewAbility;
import it.polimi.swimv2.entities.NewAbility;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="NewAbilityBean")
@Remote(INewAbility.class)
public class NewAbilityBean implements INewAbility {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public NewAbilityBean() {}

	@Override
	public List<NewAbility> findAllNewAbilities() {
		// TODO Auto-generated method stub
		String q = "SELECT a FROM NewAbility a";
		Query query = entityManager.createQuery(q);
		try{
			List<NewAbility> newAbilitiesList = (List<NewAbility>) query.getResultList();
			return newAbilitiesList;
			
		}catch (NoResultException e){
			return null;
		}
	}	

	
}
