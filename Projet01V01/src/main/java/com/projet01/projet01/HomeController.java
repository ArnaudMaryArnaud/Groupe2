package com.projet01.projet01;


import java.util.Date;

import metier.InterfaceMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Entities.Clients;
import Entities.Comptes;
import Entities.Employe;
import Entities.Groupe;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private InterfaceMetier metier;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {
	
		
		return "Compte";
	}
	@RequestMapping(value = "/Compte", method = RequestMethod.GET)
	public String homeCompte(Model model) {
		
		model.addAttribute("comptes", metier.consultercompte());
		
		
		return "Compte";
	}
	
	@RequestMapping(value = "/addCompte", method = RequestMethod.GET)
	public String addCompte(Model model, Comptes c, Long codeEmploye, Long codeClient) {
		
	
		
		metier.addcompte(c, codeEmploye, codeClient);
		model.addAttribute("comptes", metier.consultercompte());
		
		
		return "Compte";
	}
	
	/* Retour de la vue employe contenant les donn�es employe et groupe */
	@RequestMapping(value = "/Employe", method = RequestMethod.GET)
	public String homeEmploye(Model model) {
		model.addAttribute("Employe", metier.consulteremployes());
		model.addAttribute("Groupe", metier.consultergroupes());
		return "Employe";
	}
	/* Ajout d'un employe */
	@RequestMapping(value = "/insereremploye", method = RequestMethod.GET)
	public String addEmploye(Model model, Employe e) {
		metier.addemploye(e);
		model.addAttribute("Employe", metier.consulteremployes());
		model.addAttribute("Groupe", metier.consultergroupes());
		return "Employe";
	}
	/* Ajout d'un groupe */
	@RequestMapping(value = "/inserergroupe")
	public String addGroupe(Model model, Groupe g) {
		metier.addgroupe(g);
		model.addAttribute("Groupe", metier.consultergroupes());
		model.addAttribute("Employe", metier.consulteremployes());
		return "Employe";
	}
	/* Ajout d'un employ� � un groupe */
	@RequestMapping(value = "/addemployegroupe")
	public String addEmployeGroupe(Model model, Long codeGroupe, Long codeEmploye) {
		metier.addemployetogroupe(codeEmploye, codeGroupe);
		model.addAttribute("Groupe", metier.consultergroupes());
		model.addAttribute("Employe", metier.consulteremployes());
		return "Employe";
	}
	/* Afficher les employ�s d'un groupe */
	@RequestMapping(value = "/employedugroupe")
	public String employedugroupe(Model model, Long codeGroupe) {
		model.addAttribute("Groupe", metier.consultergroupes());
		model.addAttribute("Employe", metier.consulteremployes());
		model.addAttribute("EmployeGroupe", metier.consulteremployesgroupe(codeGroupe));
		return "Employe";
	}
	/* Afficher les comptes cr��s par un employ� */
	@RequestMapping(value = "/affichercompteEmp")
	public String compteEmploye(Model model, Long codeEmploye) {
		model.addAttribute("Groupe", metier.consultergroupes());
		model.addAttribute("Employe", metier.consulteremployes());
		model.addAttribute("Comptes", metier.consultercompteemploye(codeEmploye));
		return "Employe";
	}
	
	
	@RequestMapping(value = "/rechercher", method = RequestMethod.GET)
	public String ClientMC(Model model, String mc) {
		
		model.addAttribute("Client", metier.consulterclientmc(mc));
	
		return "Client";
	}
	@RequestMapping(value = "/Client", method = RequestMethod.GET)
	public String homeClient(Model model) {
	
	
		return "Client";
	}
	@RequestMapping(value="/ajouter", method=RequestMethod.GET)
	public String addclient(Model model, Clients c){
		
		metier.addclient(c);
		model.addAttribute("Client", metier.consulterclientmc(""));
		
		return "Client";
	}
	
	
	
}
