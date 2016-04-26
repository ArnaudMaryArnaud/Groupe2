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

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Clients;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;
import Entities.Operation;
import Entities.Retrait;
import Entities.Versement;

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
	public Groupe addemployetogroupe(Employe e, long codeGroupe) {
		/* methode qui ajoute un employé à un groupe */
		Groupe g = em.find(Groupe.class, codeGroupe);
		g.getListemploye().add(e);
		return g;
	}

	@Override
	public Comptes addcompte(Comptes c) {
		/* methode qui ajoute un compte à la database */
		em.persist(c);
		return c;
	}

	@Override
	public Operation addoperation(Operation o) {
		/* methode qui ajoute une opération à la database */
		em.persist(o);
		return o;
	}

	@Override
	public Comptes consultercompte(long numCompte) {
		/* methode qui permet de consulter un compte à partir de son numéro de compte */
		Comptes c = em.find(Comptes.class, numCompte);
		return c;
	}

	@Override
	public List<Comptes> consultercompteclient(long codeClient) {
		/* methode qui permet de consulter les comptes d'un client */
		Query query = em.createQuery("from comptes c where c.codeClient = "
				+ codeClient);
		return query.getResultList();
	}

	@Override
	public List<Comptes> consultercompteemploye(long codeEmploye) {
		/* méthode qui permet de consulter l'ensemble des comptes créé par un employé */
		Query query = em.createQuery("from comptes c where c.codeEmploye = "
				+ codeEmploye);
		return query.getResultList();
	}

	@Override
	public List<Employe> consulteremployes() {
		/* méthode qui permet de consulter l'ensemble des employés */
		Query query = em.createQuery("from employe e");
		return query.getResultList();
	}

	@Override
	public List<Groupe> consultergroupes() {
		/* méthode qui permet de consulter l'ensemble des groupes */
		Query query = em.createQuery("from groupe g");
		return query.getResultList();
	}

	@Override
	public List<Employe> consulteremployesgroupe(long codeGroupe) {
		/* méthode qui permet de consulter l'ensemble des employés d'un même groupe */
		Query query = em.createQuery("from Employe e where e.groupe = "+codeGroupe);
		return query.getResultList();
	}

	@Override
	public List<Clients> consulterclientmc(String mc) {
		/* méthode qui permet de rechercher dans la liste des clients les clients dont le nom commence par un mot clé */
		Query query = em.createQuery("from clients c where c.nomClient like '%"+mc);
		return query.getResultList();
	}

	@Override
	public void effectuerversement(Versement v, long numCompte) {
		/* méthode qui permet d'effectuer un versement sur un compte*/
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()+v.getMontant());
		em.merge(c);
	}

	@Override
	public void effectuerretrait(Retrait r, long numCompte) {
		/* méthode qui permet d'effectuer un retrait sur un compte */
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()-r.getMontant());
		em.merge(c);
	}

	@Override
	public void effectuervirement(double montant, long compteRetrait,
			/* méthode qui permet d'effectuer un virement d'un compte à un autre */
			long compteVersement) {
		/*on va créer un retrait sur le premier compte et un versement sur le deuxième */
		Retrait r = new Retrait(new Date(), montant);
		Versement v = new Versement(new Date(), montant);
		effectuerretrait(r, compteRetrait);
		effectuerversement(v, compteVersement);
	}

}
