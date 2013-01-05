package it.polimi.swimv2.business;


import it.polimi.swimv2.entities.JobRequest;

import java.util.List;

import javax.ejb.Remote;

//Interface for JobRequest Session Bean
@Remote
public interface IJobRequest {

	void saveJobRequest(JobRequest JobRequest);
    
	JobRequest findJobRequest(JobRequest jobRequest);
	
	JobRequest findJobRequestById(int id);
	
    List<JobRequest> findJobRequestByPerformer(int idPerformer);

    List<JobRequest> findJobRequestByRequestor(int idRequestor);
}