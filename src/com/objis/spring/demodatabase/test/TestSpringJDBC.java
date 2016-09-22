package com.objis.spring.demodatabase.test;

import com.objis.spring.demodatabase.SpringJDBC;
import com.objis.spring.domaine.Employe;

import junit.framework.TestCase;

public class TestSpringJDBC extends TestCase {

private Employe emp ;
private Employe emp2 ;
private String beanDataSource;
private SpringJDBC springjdbc ;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(6,"thom","mdpobjis","thomas","THEODOROU","thom.theodorou@live.com","employe");
		emp2 = new Employe(7,"thom","mdpobjis","thomas","THEODOROU","thom.theodorou@live.com","employe");
		beanDataSource = "datasource2";
        springjdbc = new SpringJDBC();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
	}

	public  void testSaveEmploye(){
		springjdbc.saveEmploye(emp, beanDataSource);
	}
	
	public void testGetEmployeById(){
		Employe employe = springjdbc.getEmployebyId(2);
		assertNotNull(employe);
	}
	
	
	public  void testSaveEmployeJdbcTemplate(){
		springjdbc.saveEmployeJdbcTemplate(emp2);
	}
}
