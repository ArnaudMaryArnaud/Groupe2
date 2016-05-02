package dao;

/*Auteur: Valérian Thomas
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.dao
 *Class:InterfaceDao
 *version:1.
 *ref-UML:InterfaceDao
 *sprint:1
 *ref-userStories:4.
 * 
 * */

import java.util.List;

import Entities.Clients;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;

public interface InterfaceDao {
	
	public Employe addemploye(Employe e);
	public Clients addclient(Clients c);
	public Groupe addgroupe(Groupe g);
	public Groupe addemployetogroupe(Long codeEmploye, Long codeGroupe);
	public Comptes addcompte(Comptes c, Long codeEmploye, Long codeClient);
	public List<Comptes> consultercompte();
	public List<Comptes> consultercompteclient(Long codeClient);
	public List<Comptes> consultercompteemploye(Long codeEmploye);
	public List<Employe> consulteremployes();
	public List<Groupe> consultergroupes();
	public List<Employe> consulteremployesgroupe(Long codeGroupe);
	public List<Clients> consulterclientmc(String mc) throws Exception;
	
}
