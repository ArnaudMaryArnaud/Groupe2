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
	public Groupe addemployetogroupe(Employe e, long codeGroupe);
	public Comptes addcompte(Comptes c, long codeEmploye, long codeClient);
	public Operation addoperation(Operation o, long codeEmploye, long numCompte); // méthode uniquement metier
	public List<Comptes> consultercompte();
	public List<Comptes> consultercompteclient(long codeClient);
	public List<Comptes> consultercompteemploye(long codeEmploye);
	public List<Employe> consulteremployes();
	public List<Groupe> consultergroupes();
	public List<Employe> consulteremployesgroupe(long codeGroupe);
	public List<Clients> consulterclientmc(String mc);
	public Operation effectuerversement(double montant, long numCompte, long codeEmploye); // méthode uniquement metier
	public Operation effectuerretrait(double montant, long numCompte, long codeEmploye); // méthode uniquement metier
	public void effectuervirement(double montant, long compteRetrait, long compteVersement, long codeEmploye); // méthode uniquement metier

}