package it.polimi.swimv2.business;


import it.polimi.swimv2.entities.Job;

import java.util.List;

import javax.ejb.Remote;

//Interface for JobRequest Session Bean
@Remote
public interface IJob {

	void saveJob(Job job);
    
	Job findJobById(int id);
	
    List<Job> findJobByPerformer(int idPerformer);

    List<Job> findJobByRequestor(int idRequestor);

	void setCommentByJobId(int jobId, String comment);

	void setFeedbackByJobId(int jobId, int feedback);
}