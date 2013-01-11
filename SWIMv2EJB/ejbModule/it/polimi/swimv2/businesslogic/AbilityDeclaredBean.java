package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IAbilityDeclared;
import it.polimi.swimv2.entities.AbilityDeclared;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "AbilityDeclaredBean")
@Remote(IAbilityDeclared.class)
public class AbilityDeclaredBean implements IAbilityDeclared {

	@PersistenceContext(unitName = "sql21573")
	private EntityManager entityManager;

	public AbilityDeclaredBean() {
	}

	@Override
	public void save(AbilityDeclared abDec) {
		entityManager.persist(abDec);

	}

	@Override
	public List<AbilityDeclared> findByUserId(int id) {

		String q = "SELECT a FROM AbilitiesDeclared a WHERE idUser = '" + id
				+ "'";
		Query query = entityManager.createQuery(q);
		try {
			List<AbilityDeclared> list = (List<AbilityDeclared>) query
					.getResultList();
			return list;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remove(int id) {
		String q = "SELECT a FROM AbilitiesDeclared a WHERE id ='" + id + "'";
		Query query = entityManager.createQuery(q);
		try {
			AbilityDeclared abDec = (AbilityDeclared) query.getSingleResult();
			entityManager.remove(abDec);
		} catch (NoResultException e) {
			System.out.println("ERRORE");
		}
	}

	@Override
	public List<AbilityDeclared> findByAbilityId(int id) {

		String q = "SELECT a FROM AbilitiesDeclared a WHERE idAbility = '" + id
				+ "'";
		Query query = entityManager.createQuery(q);

		try {
			List<AbilityDeclared> list = (List<AbilityDeclared>) query
					.getResultList();

			return list;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void remove(int idAbility, int idUser) {
		String q = "SELECT a FROM AbilitiesDeclared a WHERE idAbility ='"
				+ idAbility + "'and idUser = '" + idUser + "'";
		Query query = entityManager.createQuery(q);
		try {
			AbilityDeclared abDec = (AbilityDeclared) query.getSingleResult();
			entityManager.remove(abDec);
		} catch (NoResultException e) {
			System.out.println("ERRORE");
		}
	}

}
