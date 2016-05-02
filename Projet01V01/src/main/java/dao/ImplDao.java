package dao;

/*Auteur: Arnaud MARY
 * nom Projet: Projet01-groupe2
 *date : 26/04/2016
 *Package: dao
 *Class: ImplDao
 *version:1.0
 *ref-UML: ImplDao
 *sprint:1
 *ref-userStories: 4
 * 
 * */


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Clients;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;


public class ImplDao implements InterfaceDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Employe addemploye(Employe e) {
		/* methode qui ajoute un employé à la database */
		em.persist(e);
		return e;
	}

	@Override
	public Clients addclient(Clients c) {
		/* methode qui ajoute un client à la database */
		em.persist(c);
		return c;
	}

	@Override
	public Groupe addgroupe(Groupe g) {
		/* methode qui ajoute un groupe à la database */
		em.persist(g);
		return g;
	}

	@Override
	public Groupe addemployetogroupe(Long codeEmploye, Long codeGroupe) {
		/* methode qui ajoute un employé à un groupe */
		Groupe g = em.find(Groupe.class, codeGroupe);
		Employe e = em.find(Employe.class, codeEmploye);
		g.getListemploye().add(e);
		e.getListegroupe().add(g);
		return g;
	}

	@Override
	public Comptes addcompte(Comptes c, Long codeEmploye, Long codeClient) {
		/* methode qui ajoute un compte à la database */
		Employe e = em.find(Employe.class, codeEmploye);
		Clients cl = em.find(Clients.class, codeClient);
		c.setEmploye(e);
		c.setClient(cl);
		em.persist(c);
		e.getComptes().add(c);  //Association Employé - Comptes
		cl.getListcompte().add(c); //Association Clients - Comptes
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comptes> consultercompte() {
		/* methode qui permet de consulter l'ensemble des comptes */
		Query query = em.createQuery("from Comptes c ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comptes> consultercompteclient(Long codeClient) {
		/* methode qui permet de consulter les comptes d'un client */
		Query query = em.createQuery("from Comptes c where c.client = "
				+ codeClient);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comptes> consultercompteemploye(Long codeEmploye) {
		/* méthode qui permet de consulter l'ensemble des comptes créé par un employé */
		Query query = em.createQuery("from Comptes c where c.employe = "
				+ codeEmploye);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> consulteremployes() {
		/* méthode qui permet de consulter l'ensemble des employés */
		Query query = em.createQuery("from Employe e");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> consultergroupes() {
		/* méthode qui permet de consulter l'ensemble des groupes */
		Query query = em.createQuery("from Groupe g");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> consulteremployesgroupe(Long codeGroupe) {
		/* méthode qui permet de consulter l'ensemble des employés d'un même groupe */
		//Query query = em.createQuery("from Employe e inner join Groupe_Employe g on e.CodeEmploye=g.employe where g.groupe = "+codeGroupe);
		Query query = em.createQuery("Select g.listemploye from Groupe g where g.codeGroupe = "+codeGroupe);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clients> consulterclientmc(String mc) throws Exception{
		/* méthode qui permet de rechercher dans la liste des clients les clients dont le nom commence par un mot clé */
		Query query = em.createQuery("from Clients c where c.nomClient like '%"+mc+"'");
		if (query.getResultList().size() == 0){
			throw new Exception("Votre recherche ne retourne rien");
		}
		return query.getResultList();
	}

}
