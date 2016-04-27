package metier;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;





import dao.InterfaceDao;
import Entities.Clients;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;
import Entities.Operation;
import Entities.Retrait;
import Entities.Versement;

/*Auteur: Henriette Sabrina
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.metier
 *Class:ImplementMetier
 *version:1.
 *ref-UML:ImplementMetier
 *sprint:1
 *ref-userStories:4.
 *association: ....
 * 
 * */

@Transactional
public class ImplementMetier implements InterfaceMetier {
	
	@PersistenceContext
	private EntityManager em;

	   private final Logger LOG=Logger.getLogger("ImplementMetier");
		
	   private InterfaceDao dao;
	   
	  
	public void setDao(InterfaceDao dao) {
		this.dao = dao;
		LOG.info("dao injected");
	}

	@Override
	public Employe addemploye(Employe e) {
		return dao.addemploye(e);
	}

	@Override
	public Clients addclient(Clients c) {
		return dao.addclient(c);
	}

	@Override
	public Groupe addgroupe(Groupe g) {
		return dao.addgroupe(g);
	}

	@Override
	public Groupe addemployetogroupe(Employe e, long codeGroupe) {
		return dao.addemployetogroupe(e, codeGroupe);
	}

	@Override
	public Comptes addcompte(Comptes c) {
		return dao.addcompte(c);
	}

	@Override
	public Operation addoperation(Operation o) {
		/* methode qui ajoute une opération à la database */
		em.persist(o);
		return o;
	}

	@Override
	public Comptes consultercompte(long numCompte) {
		return dao.consultercompte(numCompte);
	}

	@Override
	public List<Comptes> consultercompteclient(long codeClient) {
		return dao.consultercompteclient(codeClient);
	}

	@Override
	public List<Comptes> consultercompteemploye(long codeEmploye) {
		return dao.consultercompteemploye(codeEmploye);
	}

	@Override
	public List<Employe> consulteremployes() {
		return dao.consulteremployes();
	}

	@Override
	public List<Groupe> consultergroupes() {
		return dao.consultergroupes();
	}

	@Override
	public List<Employe> consulteremployesgroupe(long codeGroupe) {
		return dao.consulteremployesgroupe(codeGroupe);
	}

	@Override
	public List<Clients> consulterclientmc(String mc) {
		return dao.consulterclientmc(mc);
	}

	@Override
	public void effectuerversement(Versement v, long numCompte, long codeEmploye) {
		/* méthode qui permet d'effectuer un versement sur un compte*/
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()+v.getMontant());
		Employe e = em.find(Employe.class, codeEmploye);
		c.setEmploye(e);
		em.merge(c);
	}

	@Override
	public void effectuerretrait(Retrait r, long numCompte, long codeEmploye) {
		/* méthode qui permet d'effectuer un retrait sur un compte */
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()-r.getMontant());
		Employe e = em.find(Employe.class, codeEmploye);
		c.setEmploye(e);
		em.merge(c);
	}

	@Override
	public void effectuervirement(double montant, long compteRetrait,
			long compteVersement, long codeEmploye) {
		/* méthode qui permet d'effectuer un virement d'un compte à un autre */
	/*on va créer un retrait sur le premier compte et un versement sur le deuxième */
	Retrait r = new Retrait(new Date(), montant);
	Versement v = new Versement(new Date(), montant);
	effectuerretrait(r, compteRetrait, codeEmploye);
	effectuerversement(v, compteVersement, codeEmploye);
	}
	
	

}
