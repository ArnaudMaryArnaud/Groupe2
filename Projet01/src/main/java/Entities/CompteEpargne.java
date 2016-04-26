package Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Comptes{
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
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(double solde, Date dateCreation) {
		super(solde, dateCreation);
		// TODO Auto-generated constructor stub
	}

	
}
