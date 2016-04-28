package Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*Auteur: Henriette Sabrina
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.Entities
 *Class: Retrait
 *version:1.
 *ref-UML:Retrait
 *sprint:1
 *ref-userStories:4.
 *association: ...
 * 
 * */


@Entity
@DiscriminatorValue("Retrait")
public class Retrait extends Operation{
	
	/*constructeur*/

	public Retrait(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
