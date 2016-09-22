package com.objis.spring.daojdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.objis.spring.domaine.Employe;

public class EmployeJdbcDaoTemplate implements IEmployeDaoJdbc {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * Utilisation de Spring JdbcTemplate pour récupérer en base un Employe
	 */
	@Override
	public Employe getEmployeById(int id) {
		String sql = "select id, nom, prenom from employe where id = ?";

		// Mapping d'un enregistrement vers un ResultSet
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				return employe;
			}
		};
		// Retourne l'objet Employe associé à l'Id
		// Notez 1) le casting explicite Employe,
		// 2) que l'enveloppe de l'argument 'id' dans un tableau d'objet,
		// 3) le boxing de 'id' comme un type reference Long
		// Ces étapes ne sont pas necessaire en utilisant (java 5)
		// SimpleJdbcTemplate
		return (Employe) jdbcTemplate.queryForObject(sql, new Object[] { Long
				.valueOf(id) }, mapper);
	}

	@Override
	public Employe getEmployeByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Utilisation de Spring JdbcTemplate pour sauver en base un Employe
	 */
	@Override
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
				+ "values (?,?,?,?,?,?,?)";

	    /*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */
		jdbcTemplate.update(
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
		final String EMPLOYE_COUNT = "select count(*) from employe";

		/*
		 * On récupère et on utilisera directement le jdbcTemplate
		 */	
		 int i = getJdbcTemplate().queryForInt(EMPLOYE_COUNT);
		
			return i;
	}

}
