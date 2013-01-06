package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.entities.Job;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="JobBean")
@Remote(IJob.class)
public class JobBean implements IJob {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public JobBean() {}

	//save job in the database
    @Override
	public void saveJob(Job job) {
		entityManager.persist(job);
	}
    
  //select job by id
    @Override
	public Job findJobById(int id) {

		String q = "SELECT j FROM Job j WHERE idJob = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			Job j = (Job) query.getSingleResult();
			return j;
		}catch (NoResultException e) {
			return null;
		}
	}

    //select job by performer
	@Override
	public List<Job> findJobByPerformer(int idPerformer) {
		String q = "SELECT j FROM Job j WHERE idPerfomer = '"+idPerformer+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<Job> list = (List<Job>) query.getResultList();
			return list;
		}catch (NoResultException e){
			return null;
		}
	}

	 //select job by requestor
		@Override
		public List<Job> findJobByRequestor(int idRequestor) {
			String q = "SELECT j FROM Job j WHERE idRequestor = '"+idRequestor+"'";
			Query query = entityManager.createQuery(q);
			try{
				List<Job> list = (List<Job>) query.getResultList();
				return list;
			}catch (NoResultException e){
				return null;
			}
		}
	
}
