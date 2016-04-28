package Entities;


import java.io.Serializable;
import java.util.Date;








import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/*Auteur: Henriette Sabrina
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.Entities
 *Class: Operation
 *version:1.
 *ref-UML: Operation
 *sprint:1
 *ref-userStories:4.
 *association: ManyToOne avec Compte, ManyToOne avec Employé
 * 
 * */


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
public class Operation implements Serializable {
	
	/*Attributs*/
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	private Date dateOperation;
	private double montant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Employe employe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Comptes compte;
	
	
	
	
	/*Getters et Setters*/
	
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Comptes getCompte() {
		return compte;
	}
	public void setCompte(Comptes compte) {
		this.compte = compte;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	/*Constructeur*/
	
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	
	
	
	

}
