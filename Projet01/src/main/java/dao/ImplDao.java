package dao;

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
		em.persist(e);
		return e;
	}

	@Override
	public Clients addclient(Clients c) {
		em.persist(c);
		return c;
	}

	@Override
	public Groupe addgroupe(Groupe g) {
		em.persist(g);
		return g;
	}

	@Override
	public Groupe addemployetogroupe(Employe e, long codeGroupe) {
		return null;
	}

	@Override
	public Comptes addcompte(Comptes c) {
		em.persist(c);
		return c;
	}

	@Override
	public Operation addoperation(Operation o) {
		em.persist(o);
		return o;
	}

	@Override
	public Comptes consultercompte(long numCompte) {
		Comptes c = em.find(Comptes.class, numCompte);
		return c;
	}

	@Override
	public List<Comptes> consultercompteclient(long codeClient) {
		Query query = em.createQuery("from comptes c where c.codeClient = "
				+ codeClient);
		return query.getResultList();
	}

	@Override
	public List<Comptes> consultercompteemploye(long codeEmploye) {
		Query query = em.createQuery("from comptes c where c.codeEmploye = "
				+ codeEmploye);
		return query.getResultList();
	}

	@Override
	public List<Employe> consulteremployes() {
		Query query = em.createQuery("from employe e");
		return query.getResultList();
	}

	@Override
	public List<Groupe> consultergroupes() {
		Query query = em.createQuery("from groupe g");
		return query.getResultList();
	}

	@Override
	public List<Employe> consulteremployesgroupe(long codeGroupe) {
		return null;
	}

	@Override
	public List<Clients> consulterclientmc(String mc) {
		return null;
	}

	@Override
	public void effectuerversement(Versement v, long numCompte) {

	}

	@Override
	public void effectuerretrait(Retrait r, long numCompte) {

	}

	@Override
	public void effectuervirement(double montant, long compteRetrait,
			long compteVersement) {

	}

}
