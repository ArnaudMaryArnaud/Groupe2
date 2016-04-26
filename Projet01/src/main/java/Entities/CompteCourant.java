package Entities;
/*Auteur: Arnaud MARY
 * nom Projet: Projet01-groupe2
 *date : 26/04/2016
 *Package: Entities
 *Class: CompteCourant
 *version:1.0
 *ref-UML: CompteCourant
 *sprint:1
 *ref-userStories: 4
 *association:
 *heritage : herite de la classe compte
 * 
 * */
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	/* attribut de la classe */
	private double decouvert;
	
	/* getter and setter */
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	/* constructeurs classe mère */
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double solde, Date dateCreation) {
		super(solde, dateCreation);
		// TODO Auto-generated constructor stub
	}

	
}
