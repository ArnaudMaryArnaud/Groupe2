package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
/*Nom du projet : Projet01-groupe2
 * Auteur : Valérian THOMAS
 * Date : 26/04/2016
 * Package : Entities
 * Classe : Employe
 * Version 1
 * Ref-UML : Employe
 * Sprint 1
 * Ref-userStories : 4
 * Association : Groupe(Many to many), Operation(One to many), Comptes(One to many)
 */


@Entity
public class Employe implements Serializable{
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeEmploye;
	private String nomEmploye;
	
	
	//association avec Groupe
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="listemploye")
	private List<Groupe> listegroupe = new ArrayList<Groupe>();
	
	//association avec Operation
	@OneToMany(mappedBy="employe")
	private List<Operation> listeoperation = new ArrayList<Operation>();
	
	//association avec Comptes
	@OneToMany(fetch=FetchType.LAZY, mappedBy="employe")
	private List<Comptes> Comptes= new ArrayList<Comptes>();
	//getters and setters
	
	public List<Operation> getListeoperation() {
		return listeoperation;
	}
	public List<Comptes> getComptes() {
		return Comptes;
	}
	public void setComptes(List<Comptes> comptes) {
		Comptes = comptes;
	}
	public void setListeoperation(List<Operation> listeoperation) {
		this.listeoperation = listeoperation;
	}
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
