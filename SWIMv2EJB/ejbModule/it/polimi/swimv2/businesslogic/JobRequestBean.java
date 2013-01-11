package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IJobRequest;
import it.polimi.swimv2.entities.JobRequest;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="JobRequestBean")
@Remote(IJobRequest.class)
public class JobRequestBean implements IJobRequest {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public JobRequestBean() {}

	//save job in the database
    @Override
	public void save(JobRequest jobRequest) {
		entityManager.persist(jobRequest);
	}
    
  //select job by id
    @Override
	public JobRequest findJobRequestById(int id) {
    	String q = "SELECT j FROM JobRequest j WHERE id = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			JobRequest j = (JobRequest) query.getSingleResult();
			return j;
		}catch (NoResultException e) {
			return null;
		}
	}

    //select job by performer
	@Override
	public List<JobRequest> findJobRequestByPerformer(int idPerformer) {
		String q = "SELECT j FROM JobRequest j WHERE idPerformer = '"+idPerformer+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<JobRequest> list = (List<JobRequest>) query.getResultList();
			return list;
		}catch (NoResultException e){
			return null;
		}
	}

	 //select job by requestor
		@Override
		public List<JobRequest> findJobRequestByRequestor(int idRequestor) {
			String q = "SELECT j FROM JobRequest j WHERE idRequestor = '"+idRequestor+"'";
			Query query = entityManager.createQuery(q);
			try{
				List<JobRequest> list = (List<JobRequest>) query.getResultList();
				return list;
			}catch (NoResultException e){
				return null;
			}
		}
		
		@Override
		public void remove(int id){		
			String q = "SELECT j FROM JobRequest j WHERE id = '"+id+"'";
			Query query = entityManager.createQuery(q);
			try{
				JobRequest jobR = (JobRequest) query.getSingleResult();
				entityManager.remove(jobR);
			}catch(NoResultException e){
					;
			}
			
		}
	    
	
}
