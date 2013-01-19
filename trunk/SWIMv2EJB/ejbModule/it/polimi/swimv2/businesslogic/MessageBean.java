package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IMessage;
import it.polimi.swimv2.entities.Message;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.Query;


@Stateless(mappedName="MessageBean")
@Remote(IMessage.class)
public class MessageBean implements IMessage {
	
	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public MessageBean() {}
    
    @Override
	public void save(Message message){
		entityManager.persist(message);
	}
    
    @Override
    public List<Message> searchByIdJob(int id){
    	System.out.println("sto creando la query");
    	String q = "SELECT m FROM Message m WHERE idJob = '"+id+"'";
    	Query query = entityManager.createQuery(q);
    	try{
    		List<Message> list = (List<Message>) query.getResultList();
    		System.out.println("lunghezza lista metodo query: "+list.size());
    		return list;	
    	}catch (NoResultException e){
    		System.out.println("ho ritornato null");
    		return null;
    	}
		
    }
	
}
