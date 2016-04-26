package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Employe {
	/*Nom du projet : Projet01-groupe2
	 * Auteur : Valérian THOMAS
	 * Date : 26/04/2016
	 * Package : Entities
	 * Classe : Employe
	 * Version 1
	 * Ref-UML : Employe
	 * Sprint 1
	 * Ref-userStories : 4
	 * Association : Groupe(Many to many), Operation(Many to one), Compte(Many to one)
	 */
	
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeEmploye;
	private String nomEmploye;
	
	//getters and setters
	public long getCodeEmploye() {
		return CodeEmploye;
	}
	public void setCodeEmploye(long codeEmploye) {
		CodeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	
	
	
	//constructeur
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	
	

}
