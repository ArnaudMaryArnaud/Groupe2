package metier;

import java.util.List;

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
 *Class:InterfaceMetier
 *version:1.
 *ref-UML:InterfaceMetier
 *sprint:1
 *ref-userStories:4.
 *association: ...
 * 
 * */

public interface InterfaceMetier {
	
	public Employe addemploye(Employe e);
	public Clients addclient(Clients c);
	public Groupe addgroupe(Groupe g);
	public Groupe addemployetogroupe(Long codeEmploye, Long codeGroupe);
	public Comptes addcompte(Comptes c, Long codeEmploye, Long codeClient);
	public Operation addoperation(Operation o, Long codeEmploye, Long numCompte); // méthode uniquement metier
	public List<Comptes> consultercompte();
	public List<Comptes> consultercompteclient(Long codeClient);
	public List<Comptes> consultercompteemploye(Long codeEmploye);
	public List<Employe> consulteremployes();
	public List<Groupe> consultergroupes();
	public List<Employe> consulteremployesgroupe(Long codeGroupe);
	public List<Clients> consulterclientmc(String mc) throws Exception;
	public Operation effectuerversement(double montant, Long numCompte, Long codeEmploye); // méthode uniquement metier
	public Operation effectuerretrait(double montant, Long numCompte, Long codeEmploye); // méthode uniquement metier
	public void effectuervirement(double montant, Long compteRetrait, Long compteVersement, Long codeEmploye); // méthode uniquement metier

}