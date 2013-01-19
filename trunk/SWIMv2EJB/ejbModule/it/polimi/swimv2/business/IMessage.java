package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.Message;

import javax.ejb.Remote;

//Interface for JobRequest Session Bean
@Remote
public interface IMessage {


	
	List<Message> searchByIdJob(int id);

	void save(Message message);
}
