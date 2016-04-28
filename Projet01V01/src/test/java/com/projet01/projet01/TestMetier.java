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

import java.util.Date;
import java.util.List;

import metier.InterfaceMetier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Entities.Clients;
import Entities.Clients;
import Entities.CompteCourant;
import Entities.CompteEpargne;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;
import Entities.Operation;
import Entities.Retrait;
import Entities.Versement;

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
		Clients c = new Clients("nom", "prenom", new Date(), "88 888");
		metier.addclient(c);
		assertNotNull(c.getCodeClient());
	}

	@Test
	public void testAddgroupe() {
		Groupe g = new Groupe("nom groupe");
		metier.addgroupe(g);
		assertNotNull(g.getCodeGroupe());
	}

	@Test
	public void testAddemployetogroupe() {
		Employe e = new Employe("test");
		Groupe g= new Groupe("GroupeTest");
		metier.addemploye(e);
		metier.addgroupe(g);
		metier.addemployetogroupe(e, g.getCodeGroupe());
		assertNotNull(g.getListemploye().size()>0);
	}

	@Test
	public void testAddcompte() {
		Comptes c = new Comptes(100, new Date());
		Clients cl2 = new Clients("zzzz", "aaaaa", new Date(), "77777");
		metier.addclient(cl2);
		metier.addcompte(c, 1L, cl2.getCodeClient());
		Comptes cc = new CompteCourant(200, new Date());
		metier.addcompte(cc, 1L, cl2.getCodeClient());
		Comptes ce = new CompteEpargne(300, new Date());
		metier.addcompte(ce, 1L, cl2.getCodeClient());
		assertNotNull(c.getNumCompte());
		assertNotNull(cc.getNumCompte());
		assertNotNull(ce.getNumCompte());
	}

	@Test
	public void testAddoperation() {
		Operation o = new Operation(new Date(), 10);
		Comptes c1 = new Comptes(500, new Date());
		Clients cl1 = new Clients("Nana", "luu", new Date(), "00000");
		Employe e = new Employe("Poiuyt");
		metier.addclient(cl1);
		metier.addemploye(e);
		metier.addcompte(c1, e.getCodeEmploye(), cl1.getCodeClient());
		metier.addoperation(o,c1.getNumCompte(), cl1.getCodeClient());
		assertNotNull(o.getNumOperation());
	}

	@Test
	public void testConsultercompte() {
		List<Comptes> tabcpt=metier.consultercompte();
		assertNotNull(tabcpt.size()>0);
	}

	@Test
	public void testConsultercompteclient() {
		List<Comptes> tabcc=metier.consultercompteclient(1L);
		assertNotNull(tabcc.size()>0);
	}

	@Test
	public void testConsultercompteemploye() {
		List<Comptes> tabce=metier.consultercompteemploye(1L);
		assertNotNull(tabce.size()>0);
	}

	@Test
	public void testConsulteremployes() {
		List<Employe> tabe=metier.consulteremployes();
		assertNotNull(tabe.size()>0);
	}

	@Test
	public void testConsultergroupes() {
		List<Groupe> tabg=metier.consultergroupes();
		assertNotNull(tabg.size()>0);
	}

	@Test
	public void testConsulteremployesgroupe() {
		List<Employe> tabeg=metier.consulteremployesgroupe(1L);
		assertNotNull(tabeg.size()>0);
	}

	@Test
	public void testConsulterclientmc() {
		List<Clients> tabcmc=metier.consulterclientmc("o");
		assertNotNull(tabcmc.size()>0);
	}

	@Test
	public void testEffectuerversement() {
		Operation v = metier.effectuerversement(15, 1L, 1L);
		assertNotNull(v.getNumOperation());
	}

	@Test
	public void testEffectuerretrait() {
		Operation or=metier.effectuerretrait(10, 1L, 1L);
		assertNotNull(or.getNumOperation());
	}

	@Test
	public void testEffectuervirement() {
		fail("Not yet implemented");
	}

}
