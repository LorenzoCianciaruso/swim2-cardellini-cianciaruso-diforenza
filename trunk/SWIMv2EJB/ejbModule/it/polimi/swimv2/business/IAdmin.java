package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.Admin;

import javax.ejb.Remote;

@Remote
public interface IAdmin {

	Admin findAdminByLogin(String email);

}
