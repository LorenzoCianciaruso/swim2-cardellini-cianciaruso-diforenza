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


@Stateless(mappedName="AbilityRequestBean")
@Remote(IAbilityRequest.class)
public class AbilityRequestBean implements IAbilityRequest {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;
	
    public AbilityRequestBean() {}

	@Override
	public List<AbilityRequest> findAllAbilityRequests() {
		// TODO Auto-generated method stub
		String q = "SELECT a FROM AbilityRequest a";
		Query query = entityManager.createQuery(q);
		try{
			List<AbilityRequest> abReqList = (List<AbilityRequest>) query.getResultList();
			return abReqList;
			
		}catch (NoResultException e){
			return null;
		}
	}
	
	

	@Override
	public void save(AbilityRequest abReq) {
		entityManager.persist(abReq);
	}	

	@Override
	public void remove(int id){
	
		String q = "SELECT a FROM AbilityRequest a WHERE idNewAbility ='"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			AbilityRequest abReq = (AbilityRequest) query.getSingleResult();
			entityManager.remove(abReq);
		}catch(NoResultException e){
				//TODO
		}
		
	}
	
	@Override
	public List<AbilityRequest> findAllAbilityReqByUserId(int id){
		String q = "SELECT a FROM AbilityRequest WHERE idUser = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<AbilityRequest> list = (List<AbilityRequest>) query.getResultList();
					return list;
		}catch (NoResultException e){
			return null;
		}
	}
		
	
}
