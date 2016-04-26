package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur: Henriette Sabrina
 * nom: Projet01-groupe2
 *date: 26/04/2016
 *Package:com.Projet1.Entities
 *Class:Client
 *version:1.
 *ref-UML:Client
 *sprint:1
 *ref-userStories:4.
 *association: OneToMany avec Compte
 * 
 * */

@Entity
public class Client {
	
	/*Attributs*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	
	@Column(name="Nom")
	private String nomClient;
	
	@Column(name="Prenom")
	private String prenomClient;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name="Code_Postal")
	private String codePostal;
	
	
	/*Getters et Setters*/
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	/*Constructeur*/
	
	public Client(String nomClient, String prenomClient, Date dateNaissance,
			String codePostal) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
	}
	
	
	

}
