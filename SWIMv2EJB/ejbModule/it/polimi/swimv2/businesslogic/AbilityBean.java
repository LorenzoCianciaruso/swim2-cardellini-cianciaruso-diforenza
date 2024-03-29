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
	public List<Ability> allAbilities() {
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
	public List<Ability> findByName(String name) {
		String q = "SELECT a FROM Ability a WHERE name LIKE '"+name+"%'";
		Query query = entityManager.createQuery(q);
		try{
			List<Ability> abilitiesList = (List<Ability>) query.getResultList();
			return abilitiesList;
		}catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public void remove(int id){
		
		String q = "SELECT a FROM Ability a WHERE id ='"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			Ability ab = (Ability) query.getSingleResult();
			entityManager.remove(ab);
		}catch(NoResultException e){		
		
		}
	}

	@Override
	public Ability findById(int id) {
		String q = "SELECT a FROM Ability a WHERE id ='"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			Ability a = (Ability) query.getSingleResult();
			return a;
		}catch(NoResultException e){
			return null;
		}
	}
	
	@Override
	public void save(Ability ab){
		entityManager.persist(ab);
	}
    
 
}
