package it.polimi.swimv2.business;


import it.polimi.swimv2.entities.JobRequest;
import it.polimi.swimv2.entities.User;

import java.util.List;

import javax.ejb.Remote;

//Interface for JobRequest Session Bean
@Remote
public interface IJobRequest {

	void saveJobRequest(JobRequest JobRequest);
    
	JobRequest findJobRequest(JobRequest jobRequest);
	
    List<JobRequest> findJobRequestByPerformer(User performer);

    List<JobRequest> findJobRequestByRequestor(User requestor);
}