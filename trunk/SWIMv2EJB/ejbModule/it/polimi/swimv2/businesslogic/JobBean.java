package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IJob;
import it.polimi.swimv2.entities.Job;
import it.polimi.swimv2.entities.User;


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
	public void save(Job job) {
		entityManager.persist(job);
	}
    
  //select job by id
    @Override
	public Job findById(int id) {

		String q = "SELECT j FROM Job j WHERE id = '"+id+"'";
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
	public List<Job> findByPerformerId(int idPerformer) {
		String q = "SELECT j FROM Job j WHERE idPerformer = '"+idPerformer+"'";
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
		public List<Job> findByRequestorId(int idRequestor) {
			String q = "SELECT j FROM Job j WHERE idRequestor = '"+idRequestor+"'";
			Query query = entityManager.createQuery(q);
			try{
				List<Job> list = (List<Job>) query.getResultList();
				return list;
			}catch (NoResultException e){
				return null;
			}
		}

		@Override
		public void setCommentById(int jobId, String comment) {
			String q = "UPDATE Job j SET comment = '"+comment+"' WHERE id = '"+jobId+"'";
			Query query = entityManager.createQuery(q);
			query.executeUpdate();
		}

		@Override
		public void setFeedbackById(int jobId, int feedback) {
			String q = "UPDATE Job j SET feedback = '"+feedback+"' WHERE id = '"+jobId+"'";
			Query query = entityManager.createQuery(q);
			query.executeUpdate();
		}
		
		@Override
		public List<Job> findByAbility(int id){
			String q = "SELECT j FROM Job j WHERE idAbility = '"+id+"'";
			Query query = entityManager.createQuery(q);
			try{
				List<Job> list = (List<Job>) query.getResultList();
				return list;
			}catch(NoResultException e){
				return null;
			}
		}
		
		@Override
		public void remove(int id){
			String q = "SELECT j FROM Job j WHERE id ='"+id+"'";
			Query query = entityManager.createQuery(q);
			try{
				Job job = (Job) query.getSingleResult();
				entityManager.remove(job);
			}catch(NoResultException e){
				
			}
		}
	
}
