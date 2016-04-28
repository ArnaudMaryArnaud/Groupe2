package Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur: Henriette Sabrina
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.Entities
 *Class: Versement
 *version:1.
 *ref-UML:Versement
 *sprint:1
 *ref-userStories:4.
 *association: ...
 * 
 * */

@Entity
@DiscriminatorValue("Versement")
public class Versement extends Operation{
	
	/*Constructeur*/

	public Versement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
