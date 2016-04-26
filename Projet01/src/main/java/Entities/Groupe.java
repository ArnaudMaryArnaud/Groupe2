package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;
/*Auteur: Arnaud MARY
 * nom Projet: Projet01-groupe2
 *date : 26/04/2016
 *Package: Entities
 *Class: Groupe
 *version:1.0
 *ref-UML: Groupes
 *sprint:1
 *ref-userStories: 4
 *association: ManytoMany avec Employe
 * 
 * */
@Entity
public class Groupe implements Serializable{
	/* attributs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeGroupe;
	private String nomGroupe;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Groupe_Employe")
	private List<Employe> listemploye = new ArrayList<Employe>();
		
	/* getter et setters */
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	public List<Employe> getListemploye() {
		return listemploye;
	}
	public void setListemploye(List<Employe> listemploye) {
		this.listemploye = listemploye;
	}
	/* constructeurs */
	public Groupe() {
	}
	public Groupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
}
