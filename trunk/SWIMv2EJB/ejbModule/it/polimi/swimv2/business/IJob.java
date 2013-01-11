package it.polimi.swimv2.business;


import it.polimi.swimv2.entities.Job;

import java.util.List;

import javax.ejb.Remote;

//Interface for JobRequest Session Bean
@Remote
public interface IJob {

	void save(Job job);
    
	Job findById(int id);
	
    List<Job> findByPerformerId(int idPerformer);

    List<Job> findByRequestorId(int idRequestor);

	void setCommentById(int jobId, String comment);

	void setFeedbackById(int jobId, int feedback);
}