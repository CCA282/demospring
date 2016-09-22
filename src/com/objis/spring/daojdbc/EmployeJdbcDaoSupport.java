package com.objis.spring.daojdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.objis.spring.domaine.Employe;

public class EmployeJdbcDaoSupport extends JdbcDaoSupport implements IEmployeDaoJdbc {

	@Override
	public Employe getEmployeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employe getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
				+ "values (?,?,?,?,?,?,?)";

		/*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */
		getJdbcTemplate().update(
				EMPLOYE_INSERT,
				new Object[] { employe.getId(),employe.getLogin(),employe.getPassword(), 
						employe.getPrenom(),employe.getNom(), employe.getEmail(),employe.getRole() });
	}

	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEmployesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
