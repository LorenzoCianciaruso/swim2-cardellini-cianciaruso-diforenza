package it.polimi.swimv2.businesslogic;

import it.polimi.swimv2.business.IAdmin;
import it.polimi.swimv2.entities.Admin;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="AdminBean")
@Remote(IAdmin.class)
public class AdminBean implements IAdmin {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public AdminBean() {}

	@Override
	public Admin findAdminByLogin(Admin a) {
		
		String q = "SELECT a FROM Admin a WHERE email = '"+a.getEmail()+"' and password = '"+a.getPassword()+"'";
		Query query = entityManager.createQuery(q);
		try{
			Admin admin = (Admin) query.getSingleResult();
			return admin;
		}catch (NoResultException e) {
			return null;
		}
	}

}
