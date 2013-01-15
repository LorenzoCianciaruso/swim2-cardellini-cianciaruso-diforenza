package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilityDeclared;

import javax.ejb.Remote;

@Remote
public interface IAbilityDeclared {

	void save(AbilityDeclared abDec);

	List<AbilityDeclared> findByUserId(int id);
	
	List<AbilityDeclared> findByAbilityId(int id);

	void remove(int id);

	void remove(int idAbility, int idUser);

	void setFeedbackById(int idAbility, int idUser, int feedback);
	
	

}
