package com.projet01.projet01;
/*Auteur: Arnaud MARY
 * nom Projet: Projet01-groupe2
 *date : 26/04/2016
 *Package: com.projet01.projet01
 *Class: TestMetier
 *version:1.0
 *ref-UML: 
 *sprint:1
 *ref-userStories: 6
 * 
 * */
import static org.junit.Assert.*;
import metier.InterfaceMetier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Entities.Employe;

public class TestMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfaceMetier metier;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("app.xml");
		metier = (InterfaceMetier) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddemploye() {
		Employe e = new Employe("nomemploye");
		metier.addemploye(e);
		assertNotNull(e.getCodeEmploye());
	}

	@Test
	public void testAddclient() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddgroupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddemployetogroupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddcompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddoperation() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultercompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultercompteclient() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultercompteemploye() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulteremployes() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultergroupes() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulteremployesgroupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterclientmc() {
		fail("Not yet implemented");
	}

	@Test
	public void testEffectuerversement() {
		fail("Not yet implemented");
	}

	@Test
	public void testEffectuerretrait() {
		fail("Not yet implemented");
	}

	@Test
	public void testEffectuervirement() {
		fail("Not yet implemented");
	}

}
