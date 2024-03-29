package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.entities.Friendship;

import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="FriendshipBean")
@Remote(IFriendship.class)
public class FriendshipBean implements IFriendship {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public FriendshipBean() {}
    
    @Override
	public void save(Friendship f) {
		entityManager.persist(f);
	}

	@Override
	public List<Friendship> findByUserId(int currentUserId) {

		String q = "SELECT f FROM Friendship f WHERE idUser1 = '"+currentUserId+"' or idUser2 = '"+currentUserId+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<Friendship> fList = (List<Friendship>) query.getResultList();
			return fList;
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remove(int id) {
		String q = "SELECT f FROM Friendship f WHERE id = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			Friendship f = (Friendship) query.getSingleResult();
			entityManager.remove(f);
		}catch(NoResultException e){
				;
		}
	}

	@Override
	public boolean isFriend(int currentUserId, int id) {
		String q = "SELECT f FROM Friendship f WHERE (idUser1 = '"+currentUserId+"' AND idUser2 = '"+id+"') OR (idUser1 ='"+id+"' AND idUser2 = '"+currentUserId+"')";
		Query query = entityManager.createQuery(q);
		try{
			Friendship f = (Friendship) query.getSingleResult();
			if(f.equals(null)){
				return false;
			}else{
				return true;
			}
		}catch(NoResultException e){
			return false;
		}
	}

}
