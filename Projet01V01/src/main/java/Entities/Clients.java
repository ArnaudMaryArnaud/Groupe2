package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 *association: OneToMany avec Comptes
 * 
 * */


@Entity
public class Clients {
	
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
	
	//Association avec comptes
	@OneToMany(mappedBy="client")
	private List<Comptes> listcompte = new ArrayList<Comptes>();
	
	
	/*Getters et Setters*/
	
	
	
	public String getNomClient() {
		return nomClient;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public List<Comptes> getListcompte() {
		return listcompte;
	}
	public void setListcompte(List<Comptes> listcompte) {
		this.listcompte = listcompte;
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
	
	public Clients(String nomClient, String prenomClient, Date dateNaissance,
			String codePostal) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
	}
	public Clients() {
		super();
	}
	
	
	
	
	

}
