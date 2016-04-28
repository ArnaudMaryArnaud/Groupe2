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
	public Groupe addemployetogroupe(Long codeEmploye, Long codeGroupe) {
		return dao.addemployetogroupe(codeEmploye, codeGroupe);
	}

	@Override
	public Comptes addcompte(Comptes c, Long codeEmploye, Long codeClient) {
		return dao.addcompte(c,codeEmploye, codeClient);
	}

	@Override
	public Operation addoperation(Operation o, Long codeEmploye, Long numCompte) {
		/* methode qui ajoute une opération à la database */
		Employe e = em.find(Employe.class, codeEmploye);
		Comptes c = em.find(Comptes.class, numCompte);
		o.setEmploye(e);
		o.setCompte(c);
		em.persist(o);
		e.getListeoperation().add(o);
		c.getListoperation().add(o);
		return o;
	}

	@Override
	public List<Comptes> consultercompte() {
		return dao.consultercompte();
	}

	@Override
	public List<Comptes> consultercompteclient(Long codeClient) {
		return dao.consultercompteclient(codeClient);
	}

	@Override
	public List<Comptes> consultercompteemploye(Long codeEmploye) {
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
	public List<Employe> consulteremployesgroupe(Long codeGroupe) {
		return dao.consulteremployesgroupe(codeGroupe);
	}

	@Override
	public List<Clients> consulterclientmc(String mc) {
		return dao.consulterclientmc(mc);
	}

	@Override
	public Operation effectuerversement(double montant, Long numCompte, Long codeEmploye) {
		/* méthode qui permet d'effectuer un versement sur un compte*/
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()+montant);
		Operation v = new Versement(new Date(), montant);
		addoperation(v, codeEmploye, numCompte);
		return v;
	}

	@Override
	public Operation effectuerretrait(double montant, Long numCompte, Long codeEmploye) {
		/* méthode qui permet d'effectuer un retrait sur un compte */
		Comptes c = em.find(Comptes.class, numCompte);
		c.setSolde(c.getSolde()-montant);
		Operation r = new Retrait(new Date(),montant);
		addoperation(r, codeEmploye, numCompte);
		return r;
	}

	@Override
	public void effectuervirement(double montant, Long compteRetrait,
			Long compteVersement, Long codeEmploye) {
			/* méthode qui permet d'effectuer un virement d'un compte à un autre */
		/*on va créer un retrait sur le premier compte et un versement sur le deuxième */
		effectuerretrait(montant, compteRetrait, codeEmploye);
		effectuerversement(montant, compteVersement, codeEmploye);
	}
	
	

}

