package com.objis.spring.daojdbc;



import java.util.List;

import com.objis.spring.domaine.Employe;

public interface IEmployeDaoJdbc {

	
	public Employe getEmployeById(int id);
	
	public Employe getEmployeByLogin(String login);
	
	public void saveEmploye(Employe employe);
	
	public List<Employe> getAllEmploye();
	
	public int getEmployesCount();
}
