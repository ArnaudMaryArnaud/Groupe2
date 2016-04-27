package Entities;
/*Auteur: Arnaud MARY
 * nom Projet: Projet01-groupe2
 *date : 26/04/2016
 *Package: Entities
 *Class: Compte
 *version:1.0
 *ref-UML: Compte
 *sprint:1
 *ref-userStories: 4
 *association: ManytoOne avec Clients, OnetoMany avec Operation et ManytoOne avec employé
 *heritage : 2 classes filles : CompteCourant et CompteEpargne
 * 
 * */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
public class Comptes implements Serializable{
	/* attributs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numCompte;
	private double solde;
	private Date dateCreation;
	/* association avec employe */
	@ManyToOne(fetch=FetchType.LAZY)
	private Employe employe;
	/*association avec operation */
	@OneToMany(mappedBy="compte")
	private List<Operation> listoperation = new ArrayList<Operation>();
	/* association avec clients */
	@ManyToOne(fetch=FetchType.LAZY)
	private Clients client;
	
	
	/* getter and setters */
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public List<Operation> getListoperation() {
		return listoperation;
	}
	public void setListoperation(List<Operation> listoperation) {
		this.listoperation = listoperation;
	}
	
	/* constructeurs */
	public Comptes(double solde, Date dateCreation) {
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	public Comptes() {
		
	}
	
	
	
	
	
}
