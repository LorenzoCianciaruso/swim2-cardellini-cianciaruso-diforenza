package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IAbilitiesDeclared;
import it.polimi.swimv2.entities.AbilitiesDeclared;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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

	@Override
	public List<AbilitiesDeclared> searchByUserId(int id) {
		
		String q = "SELECT a FROM AbilitiesDeclared a WHERE idUser = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<AbilitiesDeclared> list = (List<AbilitiesDeclared>) query.getResultList();
			return list;
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public void remove(int id) {
		String q = "SELECT a FROM AbilitiesDeclared a WHERE id ='"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			AbilitiesDeclared abDec = (AbilitiesDeclared) query.getSingleResult();
			entityManager.remove(abDec);
		}catch(NoResultException e){
			System.out.println("ERRORE");
		}
	}
    
	@Override
	public List<AbilitiesDeclared> searchByAbilityId(int id){
		
		String q = "SELECT a FROM AbilitiesDeclared a WHERE idAbility = '"+id+"'";
		Query query = entityManager.createQuery(q);
	
		try{
				List<AbilitiesDeclared> list = (List<AbilitiesDeclared>) query.getResultList();
				
				return list;
		}catch(NoResultException e){
				return null;
		}
		
	}
	
	@Override
	public void remove(int idAbility, int idUser) {
		String q = "SELECT a FROM AbilitiesDeclared a WHERE idAbility ='"+idAbility+"'and idUser = '"+idUser+"'";
		Query query = entityManager.createQuery(q);
		try{
			AbilitiesDeclared abDec = (AbilitiesDeclared) query.getSingleResult();
			entityManager.remove(abDec);
		}catch(NoResultException e){
			System.out.println("ERRORE");
		}
	}
	

    

}
